package com.cricket.repository;

import org.springframework.data.repository.CrudRepository;

import com.cricket.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
