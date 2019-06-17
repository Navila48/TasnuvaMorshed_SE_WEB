package com.cricket.repository;

import org.springframework.data.repository.CrudRepository;

import com.cricket.model.Country;

public interface CountryRepository extends CrudRepository<Country, Integer> {

}
