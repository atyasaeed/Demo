package com.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.EmployeeType;
import com.demo.repositry.EmployeeTypeRepo;

@Service
@Transactional
public class EmployeeTypeService {
	@Autowired
	EmployeeTypeRepo employeeTypeRepo;

	public void add(EmployeeType entity) {
		employeeTypeRepo.save(entity);

	}

}
