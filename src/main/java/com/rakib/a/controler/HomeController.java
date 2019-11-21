package com.rakib.a.controler;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.rakib.b.service.UserService;
import com.rakib.e.models.Users;

@CrossOrigin(origins = "*")
@RestController
public class HomeController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public Users saveUser(@RequestBody Users user) {
		System.out.println(user);
		Users users = new Users();
		users.setName(user.getName());
		users.setEmail(user.getEmail());
		users.setPassword(user.getPassword());
		users.setAddress(user.getAddress());

		return userService.saveUser(users);
	}
	
	@RequestMapping(value = "/savealluser", method = RequestMethod.POST)
	public String saveMultiUser(@RequestBody List<Users> user) {
		userService.saveAllUser(user);
		return "OK";
	}

	@RequestMapping(value = "/getalluser", method = RequestMethod.GET)
	public List<Users> getAllUser(Users user) {
		return userService.getAllUser();
	}

	@RequestMapping(value = "/getuser/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getOneUser(@PathVariable("id") int id) {

		try {
			Users user = userService.getUser(id);
			if (user != null) {
				return ResponseEntity.status(HttpStatus.OK).body(user);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	@RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
	}
	
	@RequestMapping(value = "/updateuser")
	public String updateuser(@RequestParam("id") int id, @RequestBody Users user ) {
		userService.updateUser(id, user);
		return "Ok Updated !!";
	}

}
