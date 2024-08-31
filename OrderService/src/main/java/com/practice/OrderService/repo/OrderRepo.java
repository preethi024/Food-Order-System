package com.practice.OrderService.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practice.OrderService.entity.Order;

@Repository
public interface OrderRepo extends MongoRepository<Order,Integer>{

	Order save(Order orderToBeSaved);

}
