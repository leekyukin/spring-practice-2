package com.practice.jwt2.domain.user.service;

import com.practice.jwt2.domain.user.domain.repository.UserRepository;
import com.practice.jwt2.domain.user.facade.UserFacade;
import com.practice.jwt2.domain.user.presentation.dto.request.CreateUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private UserFacade userFacade;

    @Transactional
    public void join(CreateUserRequestDto request) {
        userFacade.checkUser(request.getEmail());
        userRepository.save(request.toEntity());
    }
}
