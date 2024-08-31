package com.practice.user.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practice.user.dto.UserDto;
import com.practice.user.entity.User;
import com.practice.user.repo.UserRepo;


@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	
	 @Autowired
    private ModelMapper mapper;
	

	public UserDto addUser(UserDto userDto) {
		User user=mapper.map(userDto,User.class);
		userRepo.save(user);
		return mapper.map(user,UserDto.class);
	}


	public ResponseEntity<UserDto> fetchUserDetailsById(Integer userId) {
		Optional<User> user=userRepo.findById(userId);
		if(user.isPresent()) {
			return new ResponseEntity<>(mapper.map(user.get(), UserDto.class),HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}

}
