package com.library.controller;


import com.library.domain.dto.user.UserDto;
import com.library.domain.entity.User;
import com.library.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    //TODO nie widzę potrzby używania tu custom-owego walidatora
    //private final UserValidator userValidator;
    private final UserServiceImpl userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public void addUser(@RequestBody UserDto user) {
        userService.addUser(user);
    }

    @DeleteMapping(path = "{libuserId}")
    public void deleteLibUser(@PathVariable("libuserId") String libUserId) {
        userService.deleteUser(libUserId);
    }

    @PutMapping(path = "{libuserId}")
    public void updateLibUser(@PathVariable("libuserId") Long libUserId, @RequestParam(required = false) String name, @RequestParam(required = false) String email) {

        //TODO refactor
        /*
        userValidator.validateIfUserExists();
        userService.updateLibUser(libUserId,name,email);*/
    }

}
