package com.library.configuration;


import com.library.domain.dto.user.UserDto;
import com.library.domain.enums.UserRole;

import com.library.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

//COMMENT this config is usless. Init database during startup if needed;

@Configuration
@RequiredArgsConstructor
public class UserConfig {

    private final UserServiceImpl userService;



    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            UserDto dominik = UserDto.builder()
                    .name("Dominik")
                    .surname("Snopek")
                    .login("Dominik123")
                    .dateOfBirth(LocalDate.of(1999, Month.JUNE, 8))
                    .password("password")
                    .role(UserRole.ADMIN)
                    .build();

            userService.addUser(dominik);

            UserDto alek = UserDto.builder()
                    .name("Alek")
                    .surname("Baczynski")
                    .login("Alek123")
                    .dateOfBirth(LocalDate.of(1999, Month.FEBRUARY, 7))
                    .password("12345678")
                    .role(UserRole.USER)
                    .build();

            userService.addUser(alek);

        };
    }
}
