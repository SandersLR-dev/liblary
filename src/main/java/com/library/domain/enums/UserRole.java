package com.library.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRole {
    USER("USER"),
    AUTHOR("AUTHOR"),
    ADMIN("ADMIN");

    private final String name;
}
