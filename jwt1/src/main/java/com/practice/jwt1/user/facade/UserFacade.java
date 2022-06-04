package com.practice.jwt1.user.facade;

import com.practice.jwt1.user.domain.repository.UserRepository;
import com.practice.jwt1.user.exception.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public void checkUser(String email) {
        if (userRepository.existsByEmail(email))
            throw UserAlreadyExistsException.EXCEPTION;

    }
}
