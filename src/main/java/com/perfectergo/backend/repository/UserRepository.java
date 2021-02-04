package com.perfectergo.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.perfectergo.backend.dto.BaseDTO;
import com.perfectergo.backend.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	User findByEmailAndPassword(String email, String password);

}
