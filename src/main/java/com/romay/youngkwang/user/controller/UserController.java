package com.romay.youngkwang.user.controller;

import com.romay.youngkwang.user.dto.request.UserSignUpDTO;
import com.romay.youngkwang.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
@Tag(name = "유저 관련 기능")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    @Operation(summary = "회원가입" , description = "회원가입 기능입니다.")
    @ApiResponse(responseCode = "200",description = "200 코드 반환시 회원가입 성공")
    public ResponseEntity<String> signUpUser(@RequestBody UserSignUpDTO userSignUpDTO){
        userService.saveUser(userSignUpDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
