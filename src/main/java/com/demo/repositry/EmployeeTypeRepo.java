package com.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.EmployeeType;

@Repository
public interface EmployeeTypeRepo extends JpaRepository<EmployeeType, Integer> {
	
	

}
