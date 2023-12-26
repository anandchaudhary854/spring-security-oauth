package com.authserver.AuthServer.controller;

import com.authserver.AuthServer.dto.RegisterDto;
import com.authserver.AuthServer.model.User;
import com.authserver.AuthServer.repository.UserRepo;
import com.authserver.AuthServer.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class UserInfoController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    AuthService authService;

    @GetMapping("/")
    public String index(Principal principal){
        return "logged in  user?";
    }
    @GetMapping("/userInfo")
    public List<User> getUserInfo(){
        return userRepo.findAll();
    }

    @PostMapping("/authServer/create")
    public User registerUser(@RequestBody RegisterDto registerDto){
        return authService.registerUser(registerDto.getUsername(), registerDto.getPassword());
    }

}
