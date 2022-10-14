package org.project;

import java.util.ArrayList;

import org.project.models.Role;
import org.project.models.User;
import org.project.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthentificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthentificationApplication.class, args);
		System.out.println("ss");
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	CommandLineRunner start(UserService service) {
		return args -> {
			service.saveRole(new Role(null,"USER 1"));
			service.saveRole(new Role(null,"ADMIN"));
			service.saveRole(new Role(null,"CUSTOMER_MANAGER"));
		
			
			service.saveUser(new User(null, "user 1", "user@gmail.com", "12345", new ArrayList<>()));
			service.saveUser(new User(null, "admin", "admin@gmail.com", "12345", new ArrayList<>()));
			service.saveUser(new User(null, "user 2", "user2@gmail.com", "12345", new ArrayList<>()));
			service.saveUser(new User(null, "user 3", "user3@gmail.com", "12345", new ArrayList<>()));
 
			
			service.addRoleToUser("user@gmail.com", "USER 1");
			service.addRoleToUser("admin@gmail.com", "ADMIN");
			service.addRoleToUser("admin@gmail.com", "USER 1");
			service.addRoleToUser("user2@gmail.com", "USER 1");
			service.addRoleToUser("user3@gmail.com", "USER 1");


			

		};
	}

}
