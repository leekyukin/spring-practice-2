package com.practice.jwt2.domain.user.facade;

import com.practice.jwt2.domain.user.domain.repository.UserRepository;
import com.practice.jwt2.domain.user.exception.UserAlreadyExitsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private UserRepository userRepository;

    public void checkUser(String email) {
        if(userRepository.existsByEmail(email))
            throw UserAlreadyExitsException.EXCEPTION;
    }
}
