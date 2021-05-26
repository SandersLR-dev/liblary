package com.library.domain.dto.user;

import com.library.domain.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {
    private String login;
    private String password;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private UserRole role;
}
