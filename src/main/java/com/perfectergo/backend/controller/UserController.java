package com.perfectergo.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.perfectergo.backend.dto.BaseDTO;
import com.perfectergo.backend.dto.UserDTO;
import com.perfectergo.backend.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController extends SpringBootServletInitializer {

	@Autowired
	private UserService userService;
	
	@PostMapping(path="/user/login")
	public BaseDTO login(@RequestBody UserDTO userDTO) {
		return this.userService.login(userDTO);
	}
	
	@GetMapping(path="/helloworld")
	public String helloworld() {
		return "Hello There!";
	}
}
