package com.quanxiaoha.weblog.common.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import org.springframework.stereotype.Component;

/**
 * @Author: lcq
 * @Date: 2024/7/26 17:06
 */
@Component
public class PasswordEncoder {

    private final String salt = "qwertyuiopasdfghjklzxcvbnm1234567890";

    public String encode(String password) {
        return SecureUtil.sha256(salt + StrUtil.DOT + password);
    }

    public boolean matches(String rawPassword, String encodedPassword) {
        return encode(rawPassword).equals(encodedPassword);
    }

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new PasswordEncoder();
        System.out.println(passwordEncoder.encode("admin"));
    }
}
