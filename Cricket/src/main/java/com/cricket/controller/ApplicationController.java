package com.cricket.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cricket.model.Country;
import com.cricket.services.CountryService;

@Controller
public class ApplicationController {

	@Autowired
	private CountryService countryService;
	@RequestMapping("/welcome")
	public String welcome(HttpServletRequest request)
	{
		request.setAttribute("mode", "HOME");
		return "welcomepage";
	}
	
	@RequestMapping("/registerCountry")
	public String countryRegistration(HttpServletRequest request)
	{
		request.setAttribute("mode", "REGISTER_COUNTRY");
		return "welcomepage";
	}
	@PostMapping("/save-country")
	public String registerCountry(@ModelAttribute Country country,BindingResult bindingResult,HttpServletRequest request)
	{
		countryService.saveMyCountry(country);
		request.setAttribute("mode","HOME");
		return "welcomepage";
	}
	
	@GetMapping("/show-countries")
	public String showCountries(HttpServletRequest request)
	{
		request.setAttribute("countries", countryService.showAllCountries());
		request.setAttribute("mode", "ALL_COUNTRIES");
		return "welcomepage";
	}
	
	@RequestMapping("/delete-country")
	public String deleteCountry(@RequestParam int id,HttpServletRequest request)
	{
		countryService.deleteMyCountry(id);
		request.setAttribute("countries", countryService.showAllCountries());
		request.setAttribute("mode", "ALL_COUNTRIES");
		return "welcomepage";
	}
	
	@RequestMapping("/edit-country")
	public String editCountry(@RequestParam int id,HttpServletRequest request)
	{
		request.setAttribute("country",countryService.editMyCountry(id));
		request.setAttribute("mode","UPDATE_COUNTRY");
		return "welcomepage";
	}
}
