package com.leo.spring1.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leo.spring1.domain.User;
import com.leo.spring1.dto.ResponseDTO;
import com.leo.spring1.service.UserService;

@Controller
public class LoginController {
	@GetMapping("/auth/login")
	public String login() {
		return "system/login";
	}
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/auth/login")
	public @ResponseBody ResponseDTO<?> login(@RequestBody User user, HttpSession session){
		User findUser = userService.getUser(user.getUsername());
		if(findUser.getUsername() == null) {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "아이디가 존재하지 않음");
		}else {
			if(user.getPassword().equals(findUser.getPassword())) {
				session.setAttribute("principal", findUser);
				return new ResponseDTO<>(HttpStatus.OK.value(), 
						findUser.getUsername() + "는 로그인에 성공했음 23/1/27");
			}else {
				return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "비밀번호다름");
			}
		}
	}
}
