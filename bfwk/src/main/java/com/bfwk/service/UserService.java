package com.bfwk.service;


import java.util.List;

import com.bfwk.exception.WkException;
import com.bfwk.model.User;

public interface UserService {

	User findUserByUsernameAndPassword(String username, String password) throws Exception;

	List<User> findAllUser(int number);

	User findUserByUsername(String username);

	List<String> findAllUserPermissions(Integer id);

	void updateBalance(String cardID, Double balance) throws WkException;

	void update(User user) throws Exception;

}
