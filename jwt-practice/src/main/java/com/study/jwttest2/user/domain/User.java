package com.study.jwttest2.user.domain;

import com.study.jwttest2.user.domain.type.Authority;
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
    private String picture;

    @Enumerated(EnumType.STRING)
    private Authority authority;
}
