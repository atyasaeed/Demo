package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.EmployeeType;
import com.demo.entity.OrderEntity;
import com.demo.repositry.OrderRepo;

@Service
public class OrderService {
	@Autowired
	OrderRepo orderRepo;

//	public void addOrder(OrderEntity order) {
//		 orderRepo.save(order);
//
//	}
//	
//	public void add(OrderEntity entity) {
//		orderRepo.save(entity);
//
//	}

}
