package com.cricket.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cricket.model.Country;
import com.cricket.repository.CountryRepository;

@Service
@Transactional
public class CountryService {

	private final CountryRepository countryRepository;
	
	public CountryService(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	public void saveMyCountry(Country country)
	{
		countryRepository.save(country);
	}
	public List<Country>showAllCountries()
	{
		List<Country>countries=new ArrayList<>();
		for(Country country:countryRepository.findAll())
		{
			countries.add(country);
		}
		return countries;
	}
	
	public void deleteMyCountry(int id)
	{
		countryRepository.delete(id);
	}
}
