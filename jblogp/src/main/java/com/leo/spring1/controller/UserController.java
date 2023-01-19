package com.leo.spring1.controller;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leo.spring1.domain.RoleType;
import com.leo.spring1.domain.User;
import com.leo.spring1.exception.Spring1Exception;
import com.leo.spring1.persistence.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/user")
	public @ResponseBody String insertUser(@RequestBody User user) {
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return user.getUsername() + " 회원가입 성공";
	}
	
	@GetMapping("/user/get/{id}")
	public @ResponseBody User getUser(@PathVariable int id) {
		User findUser = userRepository.findById(id).orElseThrow(new Supplier<Spring1Exception>() {
			@Override
			public Spring1Exception get() {
				return new Spring1Exception(id + " 회원 없음");
			}
		});
		return findUser;
	}
	
	// p81 회원수정
	
	@Transactional // 나중수정
	@PutMapping("user")
	public @ResponseBody String updateUser(@RequestBody User user) {
		User findUser = userRepository.findById(user.getId()).orElseThrow(()->{
			return new Spring1Exception(user.getId() + " 회원없음");
		});
		findUser.setUsername(user.getUsername());
		findUser.setPassword(user.getPassword());
		findUser.setEmail(user.getEmail());
		// userRepository.save(findUser); // @Transactional 이 있으면 지움
		return "회원수정성공";
	}
	
	// p84 회원삭제
	@DeleteMapping("/user/{id}")
	public @ResponseBody String deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
		return "회원삭제성공";
	}
	
	//p86 목록검색
	
	@GetMapping("/user/list")
	public @ResponseBody List<User> getUserList(){
		return userRepository.findAll();
	}

	// 87 페이징처리
	
	//http://localhost:8080/user/page/0
	@GetMapping("/user/page/{page}")
	public @ResponseBody Page<User> getUserListPaging(@PathVariable int page){
		Pageable pageable=
				PageRequest.of(page,  2, Sort.Direction.DESC, "id", "username");
		return userRepository.findAll(pageable);
	}
	
	
	// http://localhost:8080/user/page
	// http://localhost:8080/user/page?page=1&size=5
	@GetMapping("/user/page")
	public @ResponseBody Page<User> getUserListPaging(@PageableDefault(
			page=0, size=3, direction=Sort.Direction.DESC, sort= {"id", "username"}) 
			Pageable pageable){

		return userRepository.findAll(pageable);
	}
	
	
}
