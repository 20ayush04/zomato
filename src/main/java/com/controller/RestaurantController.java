package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.RestaurantEntity;
import com.repository.RestaurantRepository;

@RestController
public class RestaurantController {

	@Autowired
	RestaurantRepository restaurantRepository;
	
	
	@PostMapping("addrestaurants")
	public RestaurantEntity addRestaurant(@RequestBody RestaurantEntity restaurantEntity) {
		restaurantRepository.save(restaurantEntity);
		return restaurantEntity;
	}
	
	
	
	@GetMapping("allrestaurants")
	public List<RestaurantEntity> getAllRestaurants() {
		List<RestaurantEntity> restaurants = restaurantRepository.findAll();
		if(restaurants.isEmpty()) {
			return null;
		}else {
			return restaurants;
		}
	}
	
	
	@GetMapping("restaurants/{restaurantId}")
	public RestaurantEntity getRestaurantsById(@PathVariable("restaurantId") Integer restaurantId) {
		Optional<RestaurantEntity> restaurants = restaurantRepository.findById(restaurantId);
		if(restaurants.isEmpty()) {
			return null;
		}else {
			RestaurantEntity restaurantEntity = restaurants.get();
			return restaurantEntity;
		}
	}
	
	
	
	@DeleteMapping("restaurants/{restaurantId}")
	public RestaurantEntity deleteRestaurantById(@PathVariable("restaurantId") Integer restaurantId , RestaurantEntity restaurantEntity) {
		Optional<RestaurantEntity> restaurant = restaurantRepository.findById(restaurantId);
		if(restaurant.isEmpty()) {
			return null;
		}else {
			restaurantRepository.deleteById(restaurantId);
			return restaurantEntity;
		}
	}
	
	
	
	@PutMapping("restaurants/{restaurantId}")
	public RestaurantEntity updateRestaurant(@PathVariable("restaurantId") Integer restaurantId, @RequestBody RestaurantEntity restaurantEntity) {
			restaurantRepository.save(restaurantEntity);
			return restaurantEntity;
		}
}