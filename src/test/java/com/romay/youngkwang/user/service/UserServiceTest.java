package com.romay.youngkwang.user.service;

import com.romay.youngkwang.user.dto.request.UserSignUpDTO;
import com.romay.youngkwang.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class UserServiceTest {

    @Autowired private UserService userService;
    @Autowired private UserRepository userRepository;

    @DisplayName("회원가입")
    @Test
    public void 회원가입() throws Exception {
        //given
        UserSignUpDTO dto = new UserSignUpDTO();
        dto.setName("이수빈");
        dto.setPassword("123456");
        dto.setSex(true);
        dto.setBirthdate(LocalDate.now());
        dto.setEmail("wjfkwf@naver.com");
        dto.setNickName("로메이123");

        //when
        Long savedUserId = userService.saveUser(dto);

        //then
        // DTO 의 userName 과 DB에 저장된 UserEntity 의 이름이 같으면 성공
        assertEquals(dto.getName(), userRepository.findById(savedUserId).get().getUserName());
    }

}