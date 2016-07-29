package io.amritanshu.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.amritanshu.api.entity.User;
import io.amritanshu.api.service.UserService;

@RestController
@RequestMapping(path = "users")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> findAll() {
		return userService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User create(@RequestBody User user) {
		return userService.create(user);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "{username}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User update(@PathVariable("username") String username, @RequestBody User user) {
		return userService.update(username, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "{username}")
	public void delete(@PathVariable("username") String username) {
		userService.delete(username);
	}
}