package com.leo.spring1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/html")
	public String html() {
		System.out.println("HTML 파일이 요청됨");
		return "redirect:hello.html";
	}
	
	@GetMapping("/img")
	public String img() {
		System.out.println("이미지파일이 요청됨");
		return "redirect:image/camping.jpg";
	}
	
	@GetMapping("/jsp")
	public String jsp(Model model) {
		System.out.println("JSP 파일이 요청됨");
		model.addAttribute("username", "흐흠 이 콘텐츠주인: 이용희");
		return "hellojsp";
	}	
	
}
