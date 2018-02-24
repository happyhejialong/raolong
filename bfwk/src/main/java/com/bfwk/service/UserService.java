package com.bfwk.service;


import java.util.List;

import com.bfwk.pojo.User;

public interface UserService {

	User findUserByUsernameAndPassword(String username, String password);

	List<User> findAllUser(int number);

	User findUserByUsername(String username);

	List<String> findAllUserPermissions(String id);

	boolean updateBalance(String cardID, Double balance);

}
