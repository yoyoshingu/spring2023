package com.leo.spring1.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leo.spring1.domain.Reply;
import com.leo.spring1.domain.User;
import com.leo.spring1.dto.ResponseDTO;
import com.leo.spring1.service.ReplyService;

@Controller
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	@PostMapping("/reply/{postId}")
	public @ResponseBody ResponseDTO<?> insertReply(@PathVariable int postId, @RequestBody Reply reply, HttpSession session){
		System.out.println("reply mapping 접근 /reply control");
		User principal = (User) session.getAttribute("principal");
		replyService.insertReply(postId, reply, principal);
		return new ResponseDTO<>(HttpStatus.OK.value(), postId + "번 포스트의 댓글이 등록됨");
	}
	
	// 댓글 삭제 p184
	@DeleteMapping("/reply/{replyId}")
	public @ResponseBody ResponseDTO<?> deleteReply(@PathVariable int replyId){
		replyService.deleteReply(replyId);
		return new ResponseDTO<>(HttpStatus.OK.value(), replyId + "번 댓글 삭제됨");
	}
}
