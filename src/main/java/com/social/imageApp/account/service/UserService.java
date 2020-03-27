package com.social.imageApp.account.service;

import java.util.List;

import com.social.imageApp.account.model.User;

public interface UserService {

	int save(User user);

	User get(int userId);

	List<User> list();

	void update(int userId, User user);

	void delete(int userId);

}
