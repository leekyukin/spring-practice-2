package com.practice.jwt1.user.facade;

import com.practice.jwt1.user.domain.User;
import com.practice.jwt1.user.domain.repository.UserRepository;
import com.practice.jwt1.user.exception.PasswordMisMatchException;
import com.practice.jwt1.user.exception.UserAlreadyExistsException;
import com.practice.jwt1.user.exception.UserNotFoundException;
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
        if(!passwordEncoder.matches(user.getPassword(), password))
            throw PasswordMisMatchException.EXCEPTION;
    }
}
