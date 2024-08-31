package com.practice.OrderService.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.practice.OrderService.dto.FoodItemDto;
import com.practice.OrderService.dto.Restaurant;
import com.practice.OrderService.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("order")
public class Order {
	private Integer orderId;
	private List<FoodItemDto>foodItemsList;
	private Restaurant restaurant;
	private UserDto userDto;
	
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public List<FoodItemDto> getFoodItemsList() {
		return foodItemsList;
	}
	public void setFoodItemsList(List<FoodItemDto> foodItemsList) {
		this.foodItemsList = foodItemsList;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(Integer orderId, List<FoodItemDto> foodItemsList, Restaurant restaurant, UserDto userDto) {
		super();
		this.orderId = orderId;
		this.foodItemsList = foodItemsList;
		this.restaurant = restaurant;
		this.userDto = userDto;
	}
	
	
	
	

}
