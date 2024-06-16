package com.ms.user.service.service;

import java.util.List;

import com.ms.user.service.entities.User;
import com.ms.user.service.payload.CustomResponse;


public interface UserService {

	User createUser(User entity);
	List<User> fetchAllUsers();
	User fetchUserById(String userId);
	User updateUserById(User entity,String userId);
	CustomResponse deleteUserById(String userId);
}
