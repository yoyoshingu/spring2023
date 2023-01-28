package com.leo.spring1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leo.spring1.domain.Post;
import com.leo.spring1.persistence.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	@Transactional
	public void insertPost(Post post) {
		post.setCnt(0);
		postRepository.save(post);
	}
	
	@Transactional(readOnly = true)
//	public List<Post> getPostList(){
//		return postRepository.findAll();
	// 리스트의 페이지를 위해 다음으로 수정
	
	public Page<Post> getPostList(Pageable pageable){
		return postRepository.findAll(pageable);
	}
}
