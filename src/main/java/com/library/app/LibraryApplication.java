package com.library.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class,  ManagementWebSecurityAutoConfiguration.class })
@ComponentScan(basePackages = {"com.library.*"})
@EnableJpaRepositories(basePackages = {"com.library.repository"})
@EnableTransactionManagement
@EntityScan(basePackages={"com.library.domain.entity"})
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }


}
