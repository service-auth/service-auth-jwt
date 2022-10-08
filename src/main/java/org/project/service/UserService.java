package org.project.service;

import java.util.List;

import org.project.models.Role;
import org.project.models.User;

public interface UserService {
	User saveUser(User user);

	Role saveRole(Role role);

	void addRoleToUser(String username, String rolename);

	User getUser(String username);

	List<User> getUsers();
}
