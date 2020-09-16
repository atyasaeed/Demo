package com.demo.repositry;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.OrderEntity;

@Repository
public interface OrderRepo extends CrudRepository<Integer, OrderEntity> {
	

}
