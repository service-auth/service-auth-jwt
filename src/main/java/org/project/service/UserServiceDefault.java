package org.project.service;

import java.util.List;

import org.project.dao.RoleRepository;
import org.project.dao.UserRepository;
import org.project.models.Role;
import org.project.models.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceDefault implements UserService {
	private UserRepository userRepository;
	private RoleRepository roleRepository;

	public User saveUser(User user) {
		return null;
	}

	public Role saveRole(Role role) {
		return null;
	}

	public void addRoleToUser(String username, String rolename) {

	}

	public User getUser(String username) {
		return null;
	}

	public List<User> getUsers() {
		return null;
	}

}
