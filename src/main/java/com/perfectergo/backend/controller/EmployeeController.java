package com.perfectergo.backend.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.perfectergo.backend.dto.BaseDTO;
import com.perfectergo.backend.dto.EmployeeDTO;
import com.perfectergo.backend.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController extends SpringBootServletInitializer {

	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping(path="/employee/list")
	public List<EmployeeDTO> getEmployeeList(){
		return employeeService.getEmployeeList();
	}
	
	@PostMapping(path="/employee/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public BaseDTO addEmployee(@RequestParam(value="name") String name,
			@RequestParam(value="email") String email,@RequestParam(value="address") String address,
			@RequestParam(value="phone") String phone,@RequestParam(value="photo") MultipartFile photo) throws IOException {
		System.out.print(photo.getSize());
		return employeeService.addEmployee(name,email,address,phone,photo);
	}
	
	
}
