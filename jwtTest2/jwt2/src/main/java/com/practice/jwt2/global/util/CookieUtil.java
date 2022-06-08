package com.practice.jwt2.global.util;

import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;

@Service
public class CookieUtil {

    public Cookie createCookie(String cookieName, String value, long time) {
        Cookie token = new Cookie(cookieName, value);
        token.setHttpOnly(true);
        token.setMaxAge((int)time);
        token.setPath("/");
        return token;
    }

    public Cookie getCookie(HttpServletRequest request, String cookieName) {
        final Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals(cookieName))
                return cookie;
        }
        return null;
    }

    public Cookie deleteCookie(HttpServletRequest request, String cookieName) {
       Cookie deletedCookie = new Cookie(cookieName, null);
       deletedCookie.setMaxAge(0);
       deletedCookie.setPath("/");
       return deletedCookie;
    }
}
