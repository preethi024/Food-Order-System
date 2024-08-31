package com.practice.OrderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.OrderService.dto.OrderDtoFromFrontEnd;
import com.practice.OrderService.entity.OrderDto;
import com.practice.OrderService.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@PostMapping("/saveOrder")
	public ResponseEntity<OrderDto>saveOrder(@RequestBody OrderDtoFromFrontEnd orderDetails){
		OrderDto orderSavedInDb=orderService.saveOrderInDb(orderDetails);
	return new ResponseEntity<>(orderSavedInDb,HttpStatus.CREATED);
	}

}
