package com.cricket.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cricket.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	List<User> findByCountry(String country);

}
