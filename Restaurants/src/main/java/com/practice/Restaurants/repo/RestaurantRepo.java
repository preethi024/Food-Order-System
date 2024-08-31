package com.practice.Restaurants.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.Restaurants.entity.Restaurant;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant,Integer> {

	List<Restaurant> findAll();
	



	

}
