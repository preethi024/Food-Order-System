package com.practice.OrderService.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDtoFromFrontEnd {
	
	private List<FoodItemDto>foodItemsList;
	private Integer userId;
	private Restaurant restaurant;
	public List<FoodItemDto> getFoodItemsList() {
		return foodItemsList;
	}
	public void setFoodItemsList(List<FoodItemDto> foodItemsList) {
		this.foodItemsList = foodItemsList;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public OrderDtoFromFrontEnd(List<FoodItemDto> foodItemsList, Integer userId, Restaurant restaurant) {
		super();
		this.foodItemsList = foodItemsList;
		this.userId = userId;
		this.restaurant = restaurant;
	}
	public OrderDtoFromFrontEnd() {
		super();
		// TODO Auto-generated constructor stub
	}

}
