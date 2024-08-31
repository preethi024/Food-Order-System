package com.practice.Restaurants;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages="com.practice")
public class RestaurantsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantsApplication.class, args);
	}
	 @Bean
	    public ModelMapper getModelMapper() {
	        return new ModelMapper();
	    }

}
