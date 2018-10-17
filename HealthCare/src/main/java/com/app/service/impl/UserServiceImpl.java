package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.model.User;
import com.app.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao dao;

	@Override
	@Transactional
	public Integer saveUser(User user) {
		return dao.saveUser(user);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		dao.updateUser(user);

	}

	@Override
	@Transactional
	public void deleteUser(Integer userId) {
		dao.deleteUser(userId);
	}

	@Override
	@Transactional(readOnly=true)
	public User getOneUser(Integer userId) {
		return dao.getOneUser(userId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}

}
