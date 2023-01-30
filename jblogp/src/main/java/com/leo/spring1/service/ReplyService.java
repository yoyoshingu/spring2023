package com.leo.spring1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leo.spring1.domain.Post;
import com.leo.spring1.domain.Reply;
import com.leo.spring1.domain.User;
import com.leo.spring1.persistence.PostRepository;
import com.leo.spring1.persistence.ReplyRepository;

@Service
public class ReplyService {
	
	@Autowired
	private ReplyRepository replyRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Transactional
	public void insertReply(int postId, Reply reply, User user) {
		Post post = postRepository.findById(postId).get();
		reply.setUser(user);
		reply.setPost(post);
		replyRepository.save(reply);
	}
	
	// 댓글삭제 p184
	@Transactional
	public void deleteReply(int replyId) {
		replyRepository.deleteById(replyId);
	}
	

}
