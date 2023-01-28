package com.leo.spring1.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leo.spring1.domain.Post;
import com.leo.spring1.domain.User;
import com.leo.spring1.dto.ResponseDTO;
import com.leo.spring1.service.PostService;

@Controller
public class PostController {
	@GetMapping({"", "/"})
	
	//to access this code goto http://localhost:8080
	
	public String getPostList() {
		return "index";
	}
	
	@GetMapping("/post/insertPost")
	public String insertPost() {
		return "post/insertPost";
	}
	
	// p145 insertPost
	@Autowired
	private PostService postService;
	
	@PostMapping("/post")
	public @ResponseBody ResponseDTO<?> insertPost(@RequestBody Post post, HttpSession session){
		User principal = (User) session.getAttribute("principal");
		post.setUser(principal);
		post.setCnt(0);
		
		postService.insertPost(post);
		return new ResponseDTO<>(HttpStatus.OK.value(), "새로운 포스트를 등록함");
	}
	

}
