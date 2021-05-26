package com.library.configuration;

import com.library.util.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Argon2PasswordEncoder(
                Constants.ENCODER_SALT_LENGTH,
                Constants.ENCODER_HASH_LENGTH,
                Constants.ENCODER_PARALLELISM,
                Constants.ENCODER_MEMORY,
                Constants.ENCODER_ITERATIONS
        );
    }
}
