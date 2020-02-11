package com.monicastudio.mscommon.utils;

import org.springframework.security.crypto.password.PasswordEncoder;

public class DemoPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        System.out.println(charSequence);
        System.out.println("===>");
        System.out.println(s);
        return true;
    }
}
