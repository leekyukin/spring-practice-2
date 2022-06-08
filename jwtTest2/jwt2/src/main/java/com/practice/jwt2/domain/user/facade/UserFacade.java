package com.practice.jwt2.domain.user.facade;

import com.practice.jwt2.domain.user.domain.User;
import com.practice.jwt2.domain.user.domain.repository.UserRepository;
import com.practice.jwt2.domain.user.exception.PasswordMismatchException;
import com.practice.jwt2.domain.user.exception.UserAlreadyExitsException;
import com.practice.jwt2.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public void checkUser(String email) {
        if(userRepository.existsByEmail(email))
            throw UserAlreadyExitsException.EXCEPTION;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public void checkPassword(String password, String requestPassword) {
        if(!passwordEncoder.matches(requestPassword, password))
            throw PasswordMismatchException.EXCEPTION;
    }
}
