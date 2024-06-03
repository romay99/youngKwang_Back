package com.romay.youngkwang.user.controller;

import com.romay.youngkwang.user.dto.UserSignUpDTO;
import com.romay.youngkwang.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUpUser(@RequestBody UserSignUpDTO userSignUpDTO){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
