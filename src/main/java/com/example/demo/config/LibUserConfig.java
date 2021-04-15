package com.example.demo.config;


import com.example.demo.entity.LibUser;
import com.example.demo.repository.LibUserRepository;
import com.example.demo.role.LibUserRole;
import com.example.demo.service.LibUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class LibUserConfig {

    private final LibUserService libUserService;

    public LibUserConfig(LibUserService libUserService) {
        this.libUserService = libUserService;
    }

    @Bean
    CommandLineRunner commandLineRunner(LibUserRepository libUserRepository)
    {
        return args -> {



            LibUser dominik= LibUser.builder()
                    .name("Dominik")
                    .surname("Snopek")
                    .username("Dominik123")
                    .dob(LocalDate.of(1999, Month.JUNE,8))
                    .password("password")
                    .libUserRole(LibUserRole.ADMIN)
                    .build();

            libUserService.addNewLibUser(dominik);

            LibUser alek = LibUser.builder()
                    .name("Alek")
                    .surname("Baczynski")
                    .username("Alek123")
                    .dob(LocalDate.of(1999, Month.FEBRUARY,7))
                    .password("12345678")
                    .libUserRole(LibUserRole.USER)
                    .build();

            libUserService.addNewLibUser(alek);

            //libUserRepository.saveAll(List.of(dominik,alek));

        };
    }
}
