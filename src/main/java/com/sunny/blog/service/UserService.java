package com.sunny.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunny.blog.model.User;
import com.sunny.blog.repository.UserRepository;

// Controller(Request시), Repository, Configuration, Sevice, Component //Controller제외하고 나머지 시작시에 띄워짐
// RestController, Bean

@Service // IOC
public class UserService {

	@Autowired
	private UserRepository userRepository; // DI
	
	@Transactional
	public void 회원가입(User user) {
		userRepository.save(user); // sava 끝나면 다시 컨트롤러로 돌아감
	}
}
