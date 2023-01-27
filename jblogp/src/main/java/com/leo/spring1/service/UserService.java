package com.leo.spring1.service;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leo.spring1.domain.RoleType;
import com.leo.spring1.domain.User;
import com.leo.spring1.persistence.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void insertUser(User user) {
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}
	
	// p116 기존사용자 조회
	@Transactional(readOnly=true)
	public User getUser(String username) {
		// 검색결과가 없을때 빈 user 객체 반환
		User findUser = userRepository.findByUsername(username).orElseGet(
				new Supplier<User>() {
					@Override
					public User get() {
						return new User();
					}
				});
		// 람다식
		// User findUser = userRepository.findByUsername(username).orElseGet(() ->{return new User();});
		return findUser;
	}
}
