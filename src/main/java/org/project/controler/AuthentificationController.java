package org.project.controler;

import java.util.List;

import org.project.models.Role;
import org.project.models.User;
import org.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthentificationController {
	@Autowired
	private UserService service;
	
	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}
	@GetMapping("/user")
	public List<User> getUser(){
		return service.getUsers();
	}
	@PostMapping(path="/user")
	public User saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	@PostMapping(path="/role")
	public Role saveRole(@RequestBody Role role) {
		return service.saveRole(role);
	}

}
