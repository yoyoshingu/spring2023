package com.leo.spring1.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leo.spring1.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
