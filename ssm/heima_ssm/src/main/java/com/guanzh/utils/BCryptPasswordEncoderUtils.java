package com.guanzh.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {

    public static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encodePassword(String pasword) {
        return bCryptPasswordEncoder.encode(pasword);
    }

    public static void main(String[] args) {
        String password = "zhangsan";
        String pwd = encodePassword(password);
        System.out.println(pwd);
    }
}
