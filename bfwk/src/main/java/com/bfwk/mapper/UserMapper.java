package com.bfwk.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bfwk.pojo.User;

public interface UserMapper {

	User findUserByUsernameAndPassword(@Param("username")String username,@Param("password")String password);

	void updateUserLoginTime(Date loginTime);

	List<User> findAllUser(int number);

	User findUserByUsername(String username);

	List<String> findAllUserPermissions(String id);

	int updateBalance(@Param("cardID")String cardID,@Param("balance") Double balance);

}
