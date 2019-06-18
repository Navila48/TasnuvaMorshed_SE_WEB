package com.cricket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cricket.model.Country;
import com.cricket.model.User;
import com.cricket.services.CountryService;
import com.cricket.services.UserService;

@Controller
public class ApplicationController {

	@Autowired
	private CountryService countryService;
	@Autowired
	private UserService userService;
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
		if(bindingResult.hasErrors())
		{			
			request.setAttribute("mode","REGISTER_COUNTRY");
			request.setAttribute("error","Field Can't be emprty");
			return "welcomepage";
		}
		else {
		countryService.saveMyCountry(country);
		request.setAttribute("mode","HOME");
		return "welcomepage";
		}
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
	
	@RequestMapping("/register-user")
	public String userRegistration(HttpServletRequest request)
	{
		request.setAttribute("mode", "REGISTER_USER");
		return "welcomepage";
	}
	
	@PostMapping("/save-user")
	public String registerUser(@Valid @ModelAttribute User user,BindingResult bindingResult,HttpServletRequest request)
	{
		if(bindingResult.hasErrors())
		{
			request.setAttribute("error","Field Can't be emprty");
			request.setAttribute("mode","REGISTER_USER");
			return "welcomepage";
		}
		else {
		userService.saveMyUser(user);
		request.setAttribute("mode","HOME");
		return "welcomepage";
		}
	}
	
	@GetMapping("/show-users")
	public String showUser( @RequestParam(defaultValue="") String country,HttpServletRequest request)
	{
		request.setAttribute("users", userService.findByName(country));
		request.setAttribute("mode", "ALL_TeamMembers");
		return "welcomepage";
	}
	
	@RequestMapping("/delete-user")
	public String deleteUser(@RequestParam int id,@RequestParam(defaultValue="") String country,HttpServletRequest request)
	{
		userService.deleteMyUser(id);
		request.setAttribute("users", userService.findByName(country));
		request.setAttribute("mode", "ALL_TeamMembers");
		return "welcomepage";
	}
	
	@RequestMapping("/edit-user")
	public String editUser(@RequestParam int id,HttpServletRequest request)
	{
		request.setAttribute("user",userService.editMyUser(id));
		request.setAttribute("mode","UPDATE_USER");
		return "welcomepage";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request)
	{
		request.setAttribute("mode","LOGIN_USER");
		return "welcomepage";
	}
	
	@RequestMapping("/login-user")
	public String userLogin(@ModelAttribute User user,HttpServletRequest request)
	{
		if(userService.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null)
		{
			return "homepage";
		}
		else
		{
			request.setAttribute("error","Invalid Username or Password");
			request.setAttribute("mode","LOGIN_USER");
			return "welcomepage";
		}
	}
}
