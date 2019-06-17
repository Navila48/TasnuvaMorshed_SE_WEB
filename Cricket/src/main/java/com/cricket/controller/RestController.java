package com.cricket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cricket.model.Country;
import com.cricket.services.CountryService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private CountryService countryService;
	
	@GetMapping("/")
	public String hello()
	{
		return "Is this working? ok,please go to welcome page";
	}
	
	@GetMapping("/saveCountry")
	public String saveCountry(@RequestParam String countryName )
	{
		Country country=new Country(countryName);
		countryService.saveMyCountry(country);
		return "Country is saved";
	}
}
