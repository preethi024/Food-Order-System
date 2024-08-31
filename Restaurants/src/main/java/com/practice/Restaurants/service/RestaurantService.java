package com.practice.Restaurants.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practice.Restaurants.dto.RestaurantDto;
import com.practice.Restaurants.entity.Restaurant;
import com.practice.Restaurants.mapper.RestaurantMapper;
import com.practice.Restaurants.repo.RestaurantRepo;


@Service
public class RestaurantService {

	
	@Autowired
	RestaurantRepo restaurantRepo;
	
	 @Autowired
	    private ModelMapper mapper;
	
	
	public List<RestaurantDto>findAllRestaurants(){
		List<Restaurant>restaurants=restaurantRepo.findAll();
		 List<RestaurantDto>restaurantDtoList=restaurants.stream().map(restaurant->RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant)).collect(Collectors.toList());
		return restaurantDtoList;
		
		
	}


	public RestaurantDto addRestaurantInDB(RestaurantDto restaurantDto) {
		System.out.println("yesyes");
		Restaurant savedRestaurant =  restaurantRepo.save(mapper.map(restaurantDto,Restaurant.class));
		System.out.println("yes");
        RestaurantDto returnRestaurantDto=mapper.map(savedRestaurant, RestaurantDto.class);
        System.out.println("No");
        return returnRestaurantDto;
	}
	
	
	public ResponseEntity<RestaurantDto>fetchRestaurantById(Integer id){
		Optional<Restaurant>restaurant=restaurantRepo.findById(id);
		if(restaurant.isPresent()) {
			return new ResponseEntity<>(mapper.map(restaurant.get(), RestaurantDto.class),HttpStatus.OK);
	}
	return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	
	}
	
}
