package com.bfwk.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfwk.mapper.UserMapper;
import com.bfwk.pojo.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		User user=userMapper.findUserByUsernameAndPassword(username,password);
		if(user!=null)
			userMapper.updateUserLoginTime(new Date());
		return user;
	}
	@Override
	public List<User> findAllUser(int number) {
		return userMapper.findAllUser((number-1)*10);
	}
	@Override
	public User findUserByUsername(String username) {
		
		return userMapper.findUserByUsername(username);
	}
	@Override
	public List<String> findAllUserPermissions(String id) {
	
		return userMapper.findAllUserPermissions(id);
	}
	@Override
	public boolean updateBalance(String cardID, Double balance) {
		
		return userMapper.updateBalance(cardID,balance)!=0;
	}

}
