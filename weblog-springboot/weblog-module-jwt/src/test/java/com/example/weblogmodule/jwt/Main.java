package com.example.weblogmodule.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @Author: lcq
 * @Date: 2023/8/30 17:04
 */
public class Main {
    public static void main(String[] args) {
        String base64 = "gR6cytlUlgMfVh08nLFZf8hMk4mdJDX5rWBVlsCbKvRlWcLwNRU6+rIPcLx21x191kJgP8udtoZuHt5yUDWtgg==";
        System.out.println(new String(Base64.getDecoder().decode(base64), StandardCharsets.US_ASCII));
        System.out.println(new String(Base64.getDecoder().decode(base64), StandardCharsets.ISO_8859_1));
        System.out.println(new String(Base64.getDecoder().decode(base64), StandardCharsets.UTF_8));
        System.out.println(new String(Base64.getDecoder().decode(base64), StandardCharsets.UTF_16BE));
        System.out.println(new String(Base64.getDecoder().decode(base64), StandardCharsets.UTF_16LE));
        System.out.println(new String(Base64.getDecoder().decode(base64), StandardCharsets.UTF_16));
    }
}
