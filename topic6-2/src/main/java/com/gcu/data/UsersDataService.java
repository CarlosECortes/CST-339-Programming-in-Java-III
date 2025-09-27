package com.gcu.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UsersRepository;

@Service
public class UsersDataService implements UsersDataAccessInterface<UserEntity> {
	private UsersRepository usersRepository;
	
	@Autowired
	public UsersDataService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}
	
	@Override
	public UserEntity findByUsername(String username) {
		return usersRepository.findByUsername(username);
	}

}
