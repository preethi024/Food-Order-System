package com.practice.OrderService.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.practice.OrderService.dto.OrderDtoFromFrontEnd;
import com.practice.OrderService.dto.UserDto;
import com.practice.OrderService.entity.Order;
import com.practice.OrderService.entity.OrderDto;
import com.practice.OrderService.repo.OrderRepo;

@Service
public class OrderService {
	
	@Autowired
	OrderRepo orderRepo;
	
	
	@Autowired
	SequenceGenerator sequenceGenerator;
	
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private ModelMapper mapper;

	public OrderDto saveOrderInDb(OrderDtoFromFrontEnd orderDetails) {
		Integer newOrderId =sequenceGenerator.generateNextOrderId();
		System.out.println("yesyes");
		UserDto userDto= fetchUserDetailsFromUserId(orderDetails.getUserId());
		System.out.println("yes");
		Order orderToBeSaved=new Order(newOrderId, orderDetails.getFoodItemsList(), orderDetails.getRestaurant(), userDto);
		System.out.println("no");
		orderRepo.save(orderToBeSaved);
	return mapper.map(orderToBeSaved, OrderDto.class);
	
	}


	private UserDto fetchUserDetailsFromUserId(Integer userId) {
		System.out.println("nono");
		
		return restTemplate.getForObject("http://USERINFORMATION/user/fetchUserById/"+userId,UserDto.class);
	}

}
