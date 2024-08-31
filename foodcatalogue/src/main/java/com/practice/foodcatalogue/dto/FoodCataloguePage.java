package com.practice.foodcatalogue.dto;

import java.util.List;

import com.practice.foodcatalogue.entity.FoodItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCataloguePage {
	private List<FoodItem> foodItemList;
	private Restaurant restaurant;
	public List<FoodItem> getFoodItemList() {
		return foodItemList;
	}
	public void setFoodItemList(List<FoodItem> foodItemList) {
		this.foodItemList = foodItemList;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public FoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
		super();
		this.foodItemList = foodItemList;
		this.restaurant = restaurant;
	}
	public FoodCataloguePage() {
		super();
		
	}
	
	
	

}
