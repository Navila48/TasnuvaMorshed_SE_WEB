package com.cricket.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cricket.model.User;
import com.cricket.repository.UserRepository;

@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}

	public void saveMyUser(User user)
	{
		userRepository.save(user);
	}
	
	public List<User> findByName(String country) {
		// TODO Auto-generated method stub
		List<User>users=new ArrayList<>();
		for(User user:userRepository.findByCountry(country))
		{
			users.add(user);
		}
		
		return users;
		  
}
	public void deleteMyUser(int id)
	{
		userRepository.delete(id);
	}
	
	public User editMyUser(int id)
	{
		return userRepository.findOne(id);
	}
	
	public User findByUsernameAndPassword(String username,String password)
	{
		return userRepository.findByUsernameAndPassword(username, password);
	}
}
