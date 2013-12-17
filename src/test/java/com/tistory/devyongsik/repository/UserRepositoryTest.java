package com.tistory.devyongsik.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tistory.devyongsik.repository.entity.User;
import com.tistory.devyongsik.repository.entity.UserManager;
import com.tistory.devyongsik.repository.entity.UserPredicates;
import com.tistory.devyongsik.util.AbstractRepositoryTest;

public class UserRepositoryTest extends AbstractRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserManagerRepository userManagerRepository;

	private UserManager savedUserManager;
	
	@Test
	public void save() {
		User user = new User();
		user.setName("need4spd5");
		
		user.setUserManager(savedUserManager);
		
		User savedUser = userRepository.save(user);
		
		assertNotNull(savedUser);
		assertEquals(user, savedUser);
	}
	
	@Test
	public void findAll() {

		List<User> users = (List<User>)userRepository.findAll();

		assertEquals(4, users.size());
	}
	
	@Test
	public void findByName() {
		List<User> users = (List<User>) userRepository.findAll(UserPredicates.nameLike("need4spd"));
		
		assertEquals(4, users.size());
	}
	
	@Test
	public void findByUserManager() {
		UserManager savedUserManager = userManagerRepository.findOne(0L);
		
		List<User> users = (List<User>) userRepository.findByUserManager(savedUserManager);
		
		assertEquals(4, users.size());
	}
}
