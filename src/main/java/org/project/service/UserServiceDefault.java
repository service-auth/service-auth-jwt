package org.project.service;

import java.util.List;

import org.project.dao.RoleRepository;
import org.project.dao.UserRepository;
import org.project.models.Role;
import org.project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;



@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceDefault implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	public void addRoleToUser(String username, String rolename) {
       User user  = userRepository.findByUsername(username);
       Role role = roleRepository.findByName(rolename);
       user.getRoles().add(role);
	}

	public User getUser(String username) {
		return userRepository.findByUsername(username);
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

}
