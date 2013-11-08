package com.tistory.devyongsik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tistory.devyongsik.repository.entity.UserManager;

public interface UserManagerRepository extends JpaRepository<UserManager, Long>{

}
