package com.three.web2.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.three.web2.pojo.Notice;
import com.three.web2.repository.NoticeRepository;

@RestController
public class HomeController {

	@Autowired
	NoticeRepository noticeRepository;
	/**
	 * 显示公告
	 * @return
	 */
	@GetMapping("/notice")
	public List<Notice> noticeList(@RequestParam(name = "p",defaultValue = "1") int page){
		return noticeRepository.findAll(PageRequest.of(page-1, 5)).getContent();
	}
	
	@GetMapping("/teacher/getTotal")
	public Map<String, Object> getTotal() {
		Map<String,Object> map=new HashMap<String, Object>();
		long c=noticeRepository.count();
		map.put("c", c);
		
		//n 当前页  c总页数
		long n=c/5;
		if(c/5==0) {
			n=1;
		}else if(c%5!=0&&c/5!=0) {
			n=c/5+1;
		}else if(c/5!=0&&c%5==0) {
			n=c/5;
		}
		map.put("n", n);
		return map;
	}
}
