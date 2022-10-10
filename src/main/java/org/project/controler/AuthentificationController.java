package org.project.controler;

import java.util.List;

import org.project.models.User;
import org.project.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthentificationController {
	private UserService service;
	
	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}
	@GetMapping("/user")
	public ResponseEntity<List<User>> getUser(){
		return ResponseEntity.ok().body(service.getUsers());
	}

}
