package com.romay.youngkwang.user.controller;

import com.romay.youngkwang.user.dto.request.UserSignUpDTO;
import com.romay.youngkwang.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUpUser(@RequestBody UserSignUpDTO userSignUpDTO){
        userService.saveUser(userSignUpDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
