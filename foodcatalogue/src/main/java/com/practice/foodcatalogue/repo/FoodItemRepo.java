package com.practice.foodcatalogue.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.foodcatalogue.entity.FoodItem;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem,Integer> {

	FoodItem save(FoodItem foodItem);

	List<FoodItem> findByRestaurantId(Integer id);

}
