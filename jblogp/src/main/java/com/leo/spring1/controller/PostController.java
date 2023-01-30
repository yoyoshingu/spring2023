package com.leo.spring1.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leo.spring1.domain.Post;
import com.leo.spring1.domain.User;
import com.leo.spring1.dto.ResponseDTO;
import com.leo.spring1.service.PostService;

@Controller
public class PostController {

// 포스트 게시전 초기 소스
//	@GetMapping({"", "/"})
//	//to access this code goto http://localhost:8080
//	public String getPostList() {
//		 return "index";  // fixed after chap5
//	}
	
//	@GetMapping({"", "/"})
//	to access this code goto http://localhost:8080
//	public String getPostList(Model model) {
//		model.addAttribute("postList", postService.getPostList());
//		 return "index";  // fixed after chap5
//	}
	// postlist의 페이지 처리를 위해 다음으로 수정함 1/28 p151

	@GetMapping({"", "/"})	 
	public String getPostList(Model model,
			@PageableDefault(size = 3, sort = "id", direction = Direction.DESC) Pageable pageable) {
		model.addAttribute("postList", postService.getPostList(pageable));
		return "index"; // fixed after chap5
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
	
	// 포스트내용보기 p 157
	@GetMapping("/post/{id}")
	public String getPost(@PathVariable int id, Model model) {
		model.addAttribute("post", postService.getPost(id));
		return "post/getPost";
	}

	// 포스트 수정하기 p160
	@GetMapping("/post/updatePost/{id}")
	public String UpdatePost(@PathVariable int id, Model model) {
		model.addAttribute("post", postService.getPost(id));
		return "post/updatePost";
	}
	
	// p164
	@PutMapping("/post")
	public @ResponseBody ResponseDTO<?> updatePost(@RequestBody Post post){
		postService.updatePost(post);
		return new ResponseDTO<>(HttpStatus.OK.value(), post.getId() + "번 포스트를 수정함");
	}
	// 포스트삭제 p167
	@DeleteMapping("/post/{id}")
	public @ResponseBody ResponseDTO<?> deletePost(@PathVariable int id){
		postService.deletePost(id);
		return new ResponseDTO<>(HttpStatus.OK.value(), id+ "번 포스트가 삭제됨");
	}
}
