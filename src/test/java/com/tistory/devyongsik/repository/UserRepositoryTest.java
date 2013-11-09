package com.tistory.devyongsik.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
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
	
	@Before
	public void setup() {
		
		UserManager userManager = new UserManager();
		userManager.setName("manager");
		
		savedUserManager = userManagerRepository.save(userManager);
		
		List<User> users = Lists.newArrayList();
		
		User user = new User();
		user.setName("need4spd4");
		user.setUserManager(userManager);
		
		User user1 = new User();
		user1.setName("need4spd4");
		user1.setUserManager(userManager);
		
		User user2 = new User();
		user2.setName("need4spd4");
		user2.setUserManager(userManager);
		
		User user3 = new User();
		user3.setName("need4spd4");
		user3.setUserManager(userManager);
		
		users.add(user);
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
		userRepository.save(users);
	}
	
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
		
		List<User> users = (List<User>) userRepository.findByUserManager(savedUserManager);
		
		assertEquals(4, users.size());
	}
}
