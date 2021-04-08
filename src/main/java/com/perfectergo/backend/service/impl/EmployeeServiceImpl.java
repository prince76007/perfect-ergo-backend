package com.perfectergo.backend.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.perfectergo.backend.dto.BaseDTO;
import com.perfectergo.backend.dto.EmployeeDTO;
import com.perfectergo.backend.model.Employee;
import com.perfectergo.backend.repository.EmployeeRepository;
import com.perfectergo.backend.service.EmployeeService;
import com.perfectergo.backend.utils.FileUploadUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<EmployeeDTO> getEmployeeList() {
		Iterable<Employee> iterable= employeeRepository.findAll();
		List<EmployeeDTO> employeeDTOs= new ArrayList<EmployeeDTO>();
		int sno=0;
		EmployeeDTO employeeDTO=null;
		for(Employee employee: iterable) {
			employeeDTO= new EmployeeDTO();
			employeeDTO.setSno(++sno+".");
			employeeDTO.setId(employee.getId());
			employeeDTO.setName(employee.getName());
			employeeDTO.setEmail(employee.getEmail());
			employeeDTO.setAddress(employee.getAddress());
			employeeDTO.setPhone(employee.getPhone());
			employeeDTO.setPhoto(employee.getPhoto());
			employeeDTOs.add(employeeDTO);
		}
		return employeeDTOs;
	}

	@Override
	public BaseDTO addEmployee(String name, String email, String address, String phone, MultipartFile photo)
			throws IOException {
		 BaseDTO baseDTO = new BaseDTO();
		 if (photo==null) {
			 baseDTO.setMessage("Failed to add");
			 baseDTO.setStatus("FAILED");
			 return baseDTO;
		}
		 Employee employee = new Employee();
		 employee.setAddress(address.trim());
		 employee.setEmail(email.trim());
		 employee.setName(name.trim());
		 employee.setPhone(phone.trim());
		 String photoName= StringUtils.cleanPath(photo.getOriginalFilename());
		 FileUploadUtil.saveFile(photoName, photo);
		 employee.setPhoto(photoName);
		 employeeRepository.save(employee);
		 
		 baseDTO.setMessage("added successfully");
		 baseDTO.setStatus("SUCCESS");
		return baseDTO;
	}

}
