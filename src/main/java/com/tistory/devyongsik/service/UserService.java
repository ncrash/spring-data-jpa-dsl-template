package com.tistory.devyongsik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tistory.devyongsik.repository.UserRepository;
import com.tistory.devyongsik.repository.entity.User;
import com.tistory.devyongsik.repository.entity.UserPredicates;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findByUserManagerId(Long userManagerId, int startOffset, int numberOfCommentsForPage) {
    	Pageable pageSpecification = new PageRequest(startOffset, numberOfCommentsForPage, new Sort(Sort.Direction.DESC, "regDttm"));
    	Page<User> requestedPage = userRepository.findByUserManagerId(userManagerId, pageSpecification);
    	
    	return requestedPage.getContent();
    }
	
	public List<User> findByName(String name) {
		return (List<User>) userRepository.findAll(UserPredicates.nameLike(name));
	}
}
