package com.practice.jwt2.domain.user.domain;

import com.practice.jwt2.domain.user.domain.type.Authority;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    @Enumerated(EnumType.STRING)
    private Authority authority;
}
