package com.authserver.AuthServer.service;

import com.authserver.AuthServer.model.Role;
import com.authserver.AuthServer.model.User;
import com.authserver.AuthServer.repository.RoleRepo;
import com.authserver.AuthServer.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class AuthService {
    @Autowired
    private UserRepo userRepository;

    @Autowired
    private RoleRepo roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

//    @Autowired
//    private TokenService tokenService;
    public User registerUser(String username, String password){

        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();

        authorities.add(userRole);
        User user = new User();
        user.setAuthorities(authorities);
        user.setPassword(encodedPassword);
        user.setUsername(username);
        return userRepository.save(user);
    }
}
