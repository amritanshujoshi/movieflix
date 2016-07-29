package io.amritanshu.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import io.amritanshu.api.entity.User;
import io.amritanshu.api.exception.UserExistsException;
import io.amritanshu.api.exception.UserNotFoundException;
import io.amritanshu.api.repository.UserRepository;

public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User create(User user) {
		User existing = userRepository.findByUsername(user.getUsername());
		if (existing != null) {
			throw new UserExistsException("User " + user.getUsername() + " already exists.");
		}
		return userRepository.create(user);
	}

	@Override
	public User update(String username, User user) {
		User existing = userRepository.findByUsername(username);
		if (existing == null) {
			throw new UserNotFoundException("User " + username + " not found.");
		}
		return userRepository.update(user);
	}

	@Override
	public void delete(String username) {
		User existing = userRepository.findByUsername(username);
		if (existing == null) {
			throw new UserNotFoundException("User " + username + " not found.");
		}
		userRepository.delete(existing);
	}

}
