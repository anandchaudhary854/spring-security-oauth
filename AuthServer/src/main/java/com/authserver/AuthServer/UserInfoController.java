package com.authserver.AuthServer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserInfoController {

    @GetMapping("/")
    public String index(Principal principal){
        return "logged in  user?";
    }
    @GetMapping("/userInfo")
    public String getUserInfo(Principal principal){
        return "logged in  user" + principal.toString();
    }

}
