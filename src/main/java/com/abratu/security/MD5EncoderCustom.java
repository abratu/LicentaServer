package com.abratu.security;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MD5EncoderCustom implements PasswordEncoder {

    private Md5PasswordEncoder encoder;

    public MD5EncoderCustom() {
        encoder = new Md5PasswordEncoder();
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return encoder.encodePassword(rawPassword.toString(), null);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encoder.isPasswordValid(encodedPassword, rawPassword.toString(), null);
    }
}
