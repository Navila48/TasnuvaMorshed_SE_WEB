package com.cricket.services;

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
}
