package com.omercan.security.jwttoken.controller;

import com.omercan.security.jwttoken.dto.AuthRequest;
import com.omercan.security.jwttoken.dto.CreateUserRequest;
import com.omercan.security.jwttoken.model.User;
import com.omercan.security.jwttoken.service.AuthService;
import com.omercan.security.jwttoken.service.JwtService;
import com.omercan.security.jwttoken.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/auth")
public class UserController {
   private final AuthService authService;
   private final UserService userService;



    public UserController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
        log.info("buraya girdi");
    }

    @GetMapping("/welcome")
    public String welcome(){
        log.info("buraya girdi");
        System.out.println("Wilkommen");

        return "Hallo es ist wilkommen";
    }

    @PostMapping("/addNewUser")
    public User addUser(@RequestBody CreateUserRequest request)
    {
        log.info("buraya girdi");
        return userService.createUser(request);


    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestBody AuthRequest request)
    {
       return authService.createAuth(request);
    }

    @GetMapping("/user")
    public String getUser(){
        return "Das ist User";

    }

    @GetMapping("/admin")
    public String getAdmin(){
        return "Das ist admin";
    }


}
