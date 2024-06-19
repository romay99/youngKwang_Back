package com.romay.youngkwang.user.domain;

import com.romay.youngkwang.user.dto.request.UserSignUpDTO;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_code")
    private Long userCode;

    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_nick_name")
    private String userNickName;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "user_reg_date")
    private LocalDate userRegDate;
    @Column(name = "user_sex")
    private boolean userSex;
    @Column(name = "user_birthdate")
    private LocalDate userBirthday;
    @Column(name = "user_is_social")
    private boolean userIsSocial;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;


    /**
     * 테스트용 유저 생성 메서드
     */
    public static User createTestUser() {
        User user = new User();
        user.userCode = 1L;
        user.userName = "test";
        user.userEmail = "test@romay.com";
        user.userPassword = "test";
        user.userRegDate = LocalDate.now();
        user.userBirthday = LocalDate.now();
        user.userIsSocial = false;
        user.userRole = UserRole.USER;
        user.userSex = true;
        return user;
    }

    /**
     * 유저 DTO -> Entity 메서드
     */
    public static User UserDTOToEntity(UserSignUpDTO dto) {
        User user = new User();
        user.userEmail = dto.getEmail();
        user.userName = dto.getName();
        user.userPassword = dto.getPassword();
        // user.userSex = dto.getSex()  TODO 불리안으로 변경
        // user.userBirthday = dto.getBirthdate();
        user.userRole = UserRole.USER;
        user.userIsSocial = false;
        user.userRegDate = LocalDate.now();

        return user;
    }
}
