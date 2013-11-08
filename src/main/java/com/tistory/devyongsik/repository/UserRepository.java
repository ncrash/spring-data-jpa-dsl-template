package com.tistory.devyongsik.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.tistory.devyongsik.repository.entity.User;
import com.tistory.devyongsik.repository.entity.UserManager;

public interface UserRepository extends JpaRepository<User, Long>, QueryDslPredicateExecutor<User> {

	Page<User> findByUserManagerId(Long userManagerId, Pageable pageable);
	
	List<User> findByUserManagerId(Long userManagerId, Sort sort);
	
	List<User> findByUserManager(UserManager userManager);
}
