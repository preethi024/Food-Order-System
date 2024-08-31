package com.practice.foodcatalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.foodcatalogue.dto.FoodCataloguePage;
import com.practice.foodcatalogue.dto.FoodItemDto;
import com.practice.foodcatalogue.service.FoodCatalogueService;

@RestController
@RequestMapping("/foodCatalogue")
public class FoodCatalogueController {

	
	@Autowired
	FoodCatalogueService foodCatalogueService;
	
	@PostMapping("/addFoodItem")
	public ResponseEntity<FoodItemDto>addFoodItem(@RequestBody FoodItemDto foodItemDto){
		FoodItemDto foodItemSaved=foodCatalogueService.addFoodItem(foodItemDto);
		return new ResponseEntity<>(foodItemSaved,HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchRestaurantAndFoodItemsById/{id}")
	public ResponseEntity<FoodCataloguePage>fetchRestaurantDetailsWithFoodMenu(@PathVariable Integer id){
		FoodCataloguePage foodCataloguePage=foodCatalogueService.fetchFoodCataloguePageDetails(id);
		return new ResponseEntity<>(foodCataloguePage,HttpStatus.OK);
	}
}
