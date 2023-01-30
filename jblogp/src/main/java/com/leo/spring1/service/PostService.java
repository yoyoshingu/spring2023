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
	
	// 포스트 내용보기 추가 p 156
	
	@Transactional(readOnly = true)
	public Post getPost(int id) {
		return postRepository.findById(id).get();
	}
	
	// 포스트수정하기 p 163
	@Transactional
	public void updatePost(Post post) {
		Post findPost = postRepository.findById(post.getId()).get();
		findPost.setTitle(post.getTitle());
		findPost.setContent(post.getContent());
	}
	
	// 포스트삭제 p166
	@Transactional
	public void deletePost(int id) {
		postRepository.deleteById(id);
	}
}
