package com.leo.spring1.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leo.spring1.domain.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer>{

}
