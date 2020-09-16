package com.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.demo.entity.EmployeeType;
import com.demo.service.EmployeeTypeService;

@RestController
@RequestMapping("api")
public class EmplloyeeTypeController {
	
	@Autowired
	EmployeeTypeService employeeTypeService;
	
	@PostMapping("addemptyp")
	public ResponseEntity<EmployeeType> add(@RequestBody EmployeeType entity){
		employeeTypeService.add(entity);
		return new ResponseEntity<EmployeeType>(HttpStatus.OK);
		
	}

}
