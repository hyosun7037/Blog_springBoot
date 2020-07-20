package com.sunny.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunny.blog.model.User;

@Controller
public class UserController {

	@PostMapping("/auth/joinProc")
	public @ResponseBody User joinProc(@RequestBody User user) { 
		// key=value 데이터만 받을 수 있음 그래서 @RequestBody를 적어줘야함
		// 응답을 데이터로 받기 위해서 @ResponseBody사용
		return user;
	}
}
