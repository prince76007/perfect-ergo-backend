package com.perfectergo.backend.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.perfectergo.backend.dto.BaseDTO;
import com.perfectergo.backend.dto.EmployeeDTO;

public interface EmployeeService {

	public List<EmployeeDTO> getEmployeeList();
	public BaseDTO addEmployee(String name, String email, String address, String phone, MultipartFile photo)  throws IOException;
}
