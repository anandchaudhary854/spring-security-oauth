package com.authserver.AuthServer;

import com.authserver.AuthServer.model.Role;
import com.authserver.AuthServer.model.User;
import com.authserver.AuthServer.repository.RoleRepo;
import com.authserver.AuthServer.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}
	@Autowired
	PasswordEncoder passwordEncoder;
	@Bean
	CommandLineRunner run(RoleRepo roleRepository, UserRepo userRepository){
		return args ->{
			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);
			User admin = new User(1, "admin", passwordEncoder.encode("password"), roles);
			userRepository.save(admin);

		};
	}

}


