package io.amritanshu.api.service;

import java.util.List;

import io.amritanshu.api.entity.User;

public interface UserService {
	
	public List<User> findAll();
	
	public User findOne(String id);
	
	public User login(String username, String password);

	public User create(User user);

	public User update(String id, User user);

	public void delete(String id);

}