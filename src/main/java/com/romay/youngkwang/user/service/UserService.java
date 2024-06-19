package com.romay.youngkwang.user.service;

import com.romay.youngkwang.user.domain.User;
import com.romay.youngkwang.user.dto.request.UserSignUpDTO;
import com.romay.youngkwang.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long saveUser(UserSignUpDTO userDTO) {
        User user = User.UserDTOToEntity(userDTO);
        userRepository.save(user);
        return user.getUserCode();
    }


}
