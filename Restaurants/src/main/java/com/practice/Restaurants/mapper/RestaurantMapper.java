package com.practice.Restaurants.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.practice.Restaurants.dto.RestaurantDto;
import com.practice.Restaurants.entity.Restaurant;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

	 RestaurantMapper INSTANCE=Mappers.getMapper(RestaurantMapper.class);
	
	
	    Restaurant mapRestaurantDtoToRestaurant(RestaurantDto restaurantDto);
	    RestaurantDto mapRestaurantToRestaurantDto(Restaurant restaurant);
}
