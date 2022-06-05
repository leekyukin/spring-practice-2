package com.practice.jwt1.global.security.jwt;

public class JwtProperties {

    //                                                   1s   > 1m > 30m
    private static final long ACCESS_TOKEN_VALID_TIME = 1000L * 60 * 30;
    //                                                    1s   > 1m > 1h > 1d > 30d
    private static final long REFRESH_TOKEN_VALID_TIME = 1000L * 60 * 60 * 24 * 30;
    private static final String ACCESS_TOKEN_NAME = "accessToken";
    private static final String REFRESH_TOKEN_NAME = "refreshToken";
}