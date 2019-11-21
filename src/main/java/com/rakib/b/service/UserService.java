package com.rakib.b.service;

import java.util.List;

import com.rakib.e.models.Users;

public interface UserService {
	Users saveUser(Users user);
	List<Users> getAllUser();
	Users getUser(int id);
	void deleteUser(int id);
	Users updateUser(int id, Users users);
	void saveAllUser(List<Users> user);
}
