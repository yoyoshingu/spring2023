package com.leo.spring1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {
	@GetMapping({"", "/"})
	
	//to access this code goto http://localhost:8080
	
	public String getPostList() {
		return "index";
	}

}
