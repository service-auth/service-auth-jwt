package org.project.dao;

import org.project.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

	public Role findByName(String username);
}