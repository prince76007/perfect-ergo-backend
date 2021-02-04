package com.perfectergo.backend.service;

import com.perfectergo.backend.dto.BaseDTO;
import com.perfectergo.backend.dto.UserDTO;

public interface UserService {

	BaseDTO login(UserDTO userDTO);

}
