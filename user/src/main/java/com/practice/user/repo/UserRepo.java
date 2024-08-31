package com.practice.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.user.entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {

}
