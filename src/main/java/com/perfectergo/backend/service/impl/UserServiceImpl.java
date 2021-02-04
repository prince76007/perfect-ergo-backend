package com.perfectergo.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfectergo.backend.dto.BaseDTO;
import com.perfectergo.backend.dto.UserDTO;
import com.perfectergo.backend.model.User;
import com.perfectergo.backend.repository.UserRepository;
import com.perfectergo.backend.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public BaseDTO login(UserDTO userDTO) {
		User user=null;
		user=userRepository.findByEmailAndPassword(userDTO.getEmail().trim(),userDTO.getPassword().trim());
		BaseDTO baseDTO= new BaseDTO();
		if(user!=null) {
			baseDTO.setStatus("SUCCESS");
			baseDTO.setMessage("Log In Successfull");
		}else {
			baseDTO.setStatus("FAILED");
			baseDTO.setMessage("Log In Failed");
		}
		return baseDTO;
	}

}
