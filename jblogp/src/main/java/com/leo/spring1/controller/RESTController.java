package com.leo.spring1.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.spring1.domain.User;

@RestController
public class RESTController {
	
	@GetMapping("/jblog")
	public User httpGet() {
		User finduser= User.builder().id(1).username("gurum").password("222").email("gurum@gmail.com").build();
		return finduser;
	}
	
	@PostMapping("/jblog")
	public String httpPost() {
		return "POST 요청 처리";
	}
	
	@PutMapping("/jblog")
	public String httpPut() {
		return "PUT request processed";
	}
	
	@DeleteMapping("/jblog")
	public String httpDelete() {
		return "Delete request processed";
	}

}
