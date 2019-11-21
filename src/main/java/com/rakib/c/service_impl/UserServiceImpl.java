package com.rakib.c.service_impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rakib.b.service.UserService;
import com.rakib.d.repository.UsersRepo;
import com.rakib.e.models.Users;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UsersRepo usersRepo;

	@Override
	public Users saveUser(Users user) {
		return usersRepo.save(user);
	}

	@Override
	public List<Users> getAllUser() {
		List<Users> user = new ArrayList<>();
		user = usersRepo.findAll();
		return user;
	}

	@Override
	public Users getUser(int id) {
		return usersRepo.getOne(id);
	}

	@Override
	public void deleteUser(int id) {
		Users user = getUser(id);
		usersRepo.delete(user);
	}

	@Override
	public Users updateUser(int id, Users users) {
		
		Users user = getUser(id);
		user.setName(users.getName());
		user.setEmail(users.getEmail());
		user.setPassword(users.getPassword());
		user.setAddress(users.getAddress());
		
		return usersRepo.save(user);
	}

	@Override
	public void saveAllUser(List<Users> user) {

		for (Users ur : user) {
			Users users = new Users();
			users.setName(ur.getName());
			users.setEmail(ur.getEmail());
			users.setPassword(ur.getPassword());
			users.setAddress(ur.getAddress());
			
			saveUser(users);
		}
	}

}
