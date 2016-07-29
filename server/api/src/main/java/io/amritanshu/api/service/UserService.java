package io.amritanshu.api.service;

import java.util.List;

import io.amritanshu.api.entity.User;

public interface UserService {
	
	public List<User> findAll();

	public User create(User user);

	public User update(String username, User user);

	public void delete(String username);

}