package com.practice.jwt1.global.security.jwt;

public class JwtProperties {

    //                                                   1s  > 1m > 30m
    public static final long ACCESS_TOKEN_VALID_TIME = 30 * 60 * 1000L;
    //                                                    1s   > 1m > 1h > 1d > 30d
    public static final long REFRESH_TOKEN_VALID_TIME = 1000L * 60 * 60 * 24 * 30;
    public static final String ACCESS_TOKEN_NAME = "accessToken";
    public static final String REFRESH_TOKEN_NAME = "refreshToken";
}