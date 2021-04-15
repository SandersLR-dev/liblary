package com.example.demo.controller;


import com.example.demo.entity.LibUser;
import com.example.demo.service.LibUserService;
import com.example.demo.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "lib")
public class LibUserController {

    private final UserValidator userValidator;
    private final LibUserService libUserService;

    @Autowired
    public LibUserController(UserValidator userValidator, LibUserService libUserService) {
        this.userValidator = userValidator;
        this.libUserService = libUserService;
    }

    @GetMapping
    public List<LibUser> getLibUser()
    {
        return libUserService.getLibUser();
    }

    @PostMapping
    public void registerNewLibUser(@RequestBody LibUser libUser)
    {
        libUserService.addNewLibUser(libUser);
    }

    @DeleteMapping(path="{libuserId}")
    public void deleteLibUser(@PathVariable("libuserId") Long libUserId)
    {
        libUserService.deleteLibUser(libUserId);
    }

    @PutMapping (path="{libuserId}")
    public void updateLibUser(@PathVariable("libuserId") Long libUserId,@RequestParam(required = false)String name,@RequestParam(required = false)String email)
    {
        //userValidator.validateIfUserExists();
        libUserService.updateLibUser(libUserId,name,email);
    }

}
