package com.three.web2.store;

import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.three.web2.pojo.Classes;
import com.three.web2.pojo.Student;
import com.three.web2.repository.ClassRepository;
import com.three.web2.repository.StudentRepository;


@Controller
public class FileUploadController {

	private final StorageService storageService;
	
	@Autowired
	ClassRepository classRepository;
	
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	public FileUploadController(StorageService storageService) {
		this.storageService = storageService;
	}

	@GetMapping("/admin/student/excel")
	public String listUploadedFiles(Model model) throws IOException {

		model.addAttribute("files", storageService.loadAll().map(
				path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
						"serveFile", path.getFileName().toString()).build().toUri().toString())
				.collect(Collectors.toList()));

		return "uploadForm";
	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		System.out.println(filename);
		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}

	@PostMapping("/")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {
		try {
			InputStream is=file.getInputStream();
			ReadExcel test =new ReadExcel();
			//判断Excel文件格式
			 Workbook wb =test.getExcel(file.getOriginalFilename(), is);
			 
			 Sheet sheet=wb.getSheetAt(0);//读取sheet(从0计数)
		        int rowNum=sheet.getLastRowNum();//读取行数(从0计数)
		        for(int i=1;i<=rowNum;i++){
		            Row row=sheet.getRow(i);//获得行
		            Student student=new Student();
		            student.setLoginName(row.getCell(0).toString());
		            student.setStuName(row.getCell(1).toString());
		            student.setStuSex(row.getCell(2).toString());
		            student.setStuAge(Integer.valueOf(row.getCell(3).toString()));
		            student.setStuIdNum(row.getCell(4).toString());
		            student.setStuNation(row.getCell(5).toString());
		            student.setStuAddress(row.getCell(6).toString());
		            student.setStuPhone(row.getCell(7).toString());
		            student.setStuStart(row.getCell(8).toString());
		            student.setStuStop(row.getCell(9).toString());
		            System.out.println(row.getCell(10).toString());
		            Classes cla=classRepository.findById(row.getCell(10).toString()).get();
		            student.setClaId(cla);
		            studentRepository.save(student);
		        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		storageService.store(file);
		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + file.getOriginalFilename() + "!");

		return "redirect:/";
	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

}
