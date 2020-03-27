package com.social.imageApp.account.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.imageApp.account.dao.UserDao;
import com.social.imageApp.account.model.User;

@Service("UserService")
@Transactional
public class UserServiceImp implements UserService {

	@Autowired(required = true)
	private UserDao userDao;

	@Transactional
	@Override
	public int save(User user) {
		return userDao.save(user);
	}

	@Override
	public User get(int userId) {
		return userDao.get(userId);
	}

	@Override
	public List<User> list() {
		return userDao.list();
	}

	@Override
	public void update(int userId, User user) {
		userDao.update(userId, user);
	}

	@Override
	public void delete(int userId) {
		userDao.delete(userId);
	}

}
