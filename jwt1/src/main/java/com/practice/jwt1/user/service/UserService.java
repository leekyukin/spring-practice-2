package com.practice.jwt1.user.service;

import com.practice.jwt1.user.domain.repository.UserRepository;
import com.practice.jwt1.user.presentation.dto.request.CreateUserRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private UserRepository userRepository;

    @Transactional
    public void signup(CreateUserRequestDto request) {
        userRepository.save(CreateUserRequestDto.toEntity(request));
    }
}
