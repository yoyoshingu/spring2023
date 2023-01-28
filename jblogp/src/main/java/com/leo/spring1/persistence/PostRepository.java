package com.leo.spring1.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leo.spring1.domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
