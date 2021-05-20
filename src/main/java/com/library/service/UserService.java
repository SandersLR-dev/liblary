package com.library.service;

import com.library.domain.dto.user.UserDto;
import com.library.domain.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    void addUser(UserDto user);

}
