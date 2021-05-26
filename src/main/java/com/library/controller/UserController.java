package com.library.controller;


import com.library.domain.dto.user.UserDto;
import com.library.domain.entity.User;
import com.library.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public void addUser(@RequestBody UserDto user) {
        userService.addUser(user);
    }

    @DeleteMapping("/users/{user_id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteLibUser(@PathVariable("user_id") String userId) {
        userService.deleteUser(userId);
    }

    @PutMapping(path = "{libuserId}")
    public void updateLibUser(@PathVariable("libuserId") Long libUserId, @RequestParam(required = false) String name, @RequestParam(required = false) String email) {

        //TODO refactor
        /*
        userValidator.validateIfUserExists();
        userService.updateLibUser(libUserId,name,email);*/
    }

}
