package com.perfectergo.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.perfectergo.backend.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

	
	
}
