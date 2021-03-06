package io.amritanshu.api.repository;

import java.util.List;

import io.amritanshu.api.entity.User;

public interface UserRepository {

	public List<User> findAll();
	
	public User findOne(String id);
	
	public User findByUsername(String username);
	
	public User login(String username, String password);

	public User create(User user);

	public User update(User user);

	public void delete(User user);

}