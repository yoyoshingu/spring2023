package com.leo.spring1.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String httpPost(@RequestBody User user) {
//		return "POST 요청 처리";
		return "POST 요청 처리값:" + user.toString();
	}
	
	@PutMapping("/jblog")
	public String httpPut() {
		return "PUT request processed";
	}
	
	@DeleteMapping("/jblog")
	public String httpDelete(@RequestParam int id) {
		return "Delete request processed id: " + id;
	}

}
