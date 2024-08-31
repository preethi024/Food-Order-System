package com.practice.foodcatalogue.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.practice.foodcatalogue.dto.FoodCataloguePage;
import com.practice.foodcatalogue.dto.FoodItemDto;
import com.practice.foodcatalogue.dto.Restaurant;
import com.practice.foodcatalogue.entity.FoodItem;
import com.practice.foodcatalogue.repo.FoodItemRepo;

@Service 
public class FoodCatalogueService {

	
	
	
	@Autowired
	FoodItemRepo foodItemRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	public FoodItemDto addFoodItem(FoodItemDto foodItemDto) {
		FoodItem foodItemSavedInDb=foodItemRepo.save(mapper.map(foodItemDto, FoodItem.class));
		
		return mapper.map(foodItemSavedInDb, FoodItemDto.class);
	}


	public FoodCataloguePage fetchFoodCataloguePageDetails(Integer id) {
		List<FoodItem> foodItemList=fetchFoodItemList(id);
		Restaurant restaurant=fetchRestaurantDetailsFromRestaurantns(id);

		return createFoodCataloguePage(foodItemList,restaurant);
	}


	private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
		// TODO Auto-generated method stub
		FoodCataloguePage foodCataloguePage=new FoodCataloguePage();
		foodCataloguePage.setFoodItemList(foodItemList);
		foodCataloguePage.setRestaurant(restaurant);
		return foodCataloguePage;
		
	}


	private Restaurant fetchRestaurantDetailsFromRestaurantns(Integer id) {
		return restTemplate.getForObject("http://RESTAURANTS/restaurant/fetchById/"+id, Restaurant.class);
	}


	private List<FoodItem> fetchFoodItemList(Integer id) {
		
		return foodItemRepo.findByRestaurantId(id);
	}

	
	
	
	
}
