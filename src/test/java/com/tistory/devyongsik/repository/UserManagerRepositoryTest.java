package com.tistory.devyongsik.repository;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.google.common.collect.Lists;
import com.tistory.devyongsik.repository.entity.User;
import com.tistory.devyongsik.repository.entity.UserManager;
import com.tistory.devyongsik.util.AbstractRepositoryTest;

public class UserManagerRepositoryTest extends AbstractRepositoryTest {
	
	@Autowired
	private UserManagerRepository userManagerRepository;
	
	@Test
	public void save() {
		UserManager userManager = new UserManager();
		userManager.setName("new_manager");
		
		List<User> users = Lists.newArrayList();
		userManager.setUsers(users);
		
		User user1 = new User();
		user1.setName("need4spd5");
		
		User user2 = new User();
		user2.setName("need4spd6");
		
		users.add(user1);
		users.add(user2);
		
		UserManager savedUserManager = userManagerRepository.save(userManager);
		
		Assert.notNull(savedUserManager);
	}

}
