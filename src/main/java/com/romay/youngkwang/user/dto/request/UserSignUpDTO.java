package com.romay.youngkwang.user.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@ToString
public class UserSignUpDTO {
    private String email;
    private String name;
    private String password;
    private boolean sex;
    private LocalDate birthdate;

}
