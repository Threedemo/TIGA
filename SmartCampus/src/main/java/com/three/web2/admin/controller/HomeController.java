package com.three.web2.admin.controller;

import java.util.List;

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
}
