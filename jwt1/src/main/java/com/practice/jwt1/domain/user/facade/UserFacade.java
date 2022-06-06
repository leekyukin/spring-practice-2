package com.practice.jwt1.domain.user.facade;

import com.practice.jwt1.domain.user.domain.User;
import com.practice.jwt1.domain.user.domain.repository.UserRepository;
import com.practice.jwt1.domain.user.exception.PasswordMisMatchException;
import com.practice.jwt1.domain.user.exception.UserAlreadyExistsException;
import com.practice.jwt1.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public void checkUser(String email) {
        if (userRepository.existsByEmail(email))
            throw UserAlreadyExistsException.EXCEPTION;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public void checkUserPassword(User user, String password) {
        if(!passwordEncoder.matches(password, user.getPassword()))
            throw PasswordMisMatchException.EXCEPTION;
    }
}
