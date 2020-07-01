package com.three.web2.store;

import java.io.InputStream;
import java.util.Optional;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.three.web2.pojo.Classes;
import com.three.web2.pojo.Student;
import com.three.web2.repository.ClassRepository;
import com.three.web2.repository.StudentRepository;

public class ReadExcel {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ClassRepository classRepository;
	
	public Workbook getExcel(String filePath,InputStream is){
        Workbook wb=null;
            String fileType=filePath.substring(filePath.lastIndexOf("."));//获得后缀名
            try {
                if(".xls".equals(fileType)){
                    wb = new HSSFWorkbook(is);
                }else if(".xlsx".equals(fileType)){
                    wb = new XSSFWorkbook(is);
                }else{
                    System.out.println("格式不正确");
                    wb=null;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        return wb;
    }

    public void analyzeExcel(Workbook wb){
        Sheet sheet=wb.getSheetAt(0);//读取sheet(从0计数)
        int rowNum=sheet.getLastRowNum();//读取行数(从0计数)
        for(int i=1;i<=rowNum;i++){
            Row row=sheet.getRow(i);//获得行
            int colNum=row.getLastCellNum();//获得当前行的列数
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
            System.out.println(cla);
            student.setClaId(cla);
            System.out.println(student);
            studentRepository.save(student);
        }
    }
}
