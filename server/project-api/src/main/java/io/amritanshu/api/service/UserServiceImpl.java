package io.amritanshu.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.amritanshu.api.entity.User;
import io.amritanshu.api.exception.UserExistsException;
import io.amritanshu.api.exception.UserNotFoundException;
import io.amritanshu.api.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findOne(String id) {
		User existing = userRepository.findOne(id);
		if (existing == null) {
			throw new UserNotFoundException("User with id:" + id + " not found.");
		}
		return existing;
	}
	
	@Override
	public User login(String username, String password) {
		User existing = userRepository.login(username, password);
		if (existing == null) {
			throw new UserNotFoundException("User with username " + username + " does not exist.");
		}
		return existing;
	}	
	
	@Override
	@Transactional
	public User create(User user) {
		User existing = userRepository.findByUsername(user.getUsername());
		if (existing != null) {
			throw new UserExistsException("User " + user.getUsername() + " already exists.");
		}
		return userRepository.create(user);
	}

	@Override
	@Transactional
	public User update(String id, User user) {
		User existing = userRepository.findOne(id);
		if (existing == null) {
			throw new UserNotFoundException("User with id:" + id + " not found.");
		}
		return userRepository.update(user);
	}

	@Override
	@Transactional
	public void delete(String id) {
		User existing = userRepository.findOne(id);
		if (existing == null) {
			throw new UserNotFoundException("User with id:" + id + " not found.");
		}
		userRepository.delete(existing);
	}

}
