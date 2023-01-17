package com.leo.spring1;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.leo.spring1.domain.User;
import com.leo.spring1.persistence.UserDAO;


//@SpringBootTest
public class UserDAOTest {
	@Autowired
	private UserDAO userDAO;
	
	@Test
	void getUserListTest() {
		User user = new User();
		user.setUsername("testy");
		user.setPassword("testy123");
		user.setEmail("testy@h.com");
		
		int before = userDAO.getUserList().size();
		userDAO.insertUser(user);
		int after = userDAO.getUserList().size();
		assertEquals(before+1, after);
		
	}

}
