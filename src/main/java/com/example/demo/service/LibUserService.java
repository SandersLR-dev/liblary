package com.example.demo.service;

import com.example.demo.entity.LibUser;
import com.example.demo.repository.LibUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class LibUserService {

    private final LibUserRepository libUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public LibUserService(LibUserRepository libUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.libUserRepository = libUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public List<LibUser> getLibUser()
    {
        return libUserRepository.findAll();
    }

    public void addNewLibUser(LibUser libUser) {
        Optional<LibUser> libUserByUsername=libUserRepository.findLibUserByUsername(libUser.getUsername());

        if(libUserByUsername.isPresent())
        {
            throw new IllegalStateException("email taken");
        }
        final String encryptedPassword = bCryptPasswordEncoder.encode(libUser.getPassword());
        libUser.setPassword(encryptedPassword);
        libUserRepository.save(libUser);

    }

    public void deleteLibUser(Long libUserId) {

        boolean exists= libUserRepository.existsById(libUserId);

        if(!exists)
        {
            throw new IllegalStateException("student with id "+ libUserId + " doesn't exists");
        }

        libUserRepository.deleteById(libUserId);
    }


    public void updateLibUser(Long libUserId, String name, String email) {

        LibUser libUser = libUserRepository.findById(libUserId).orElseThrow(()->new IllegalStateException("student wint id "+ libUserId+" doesn't exists"));

        if(name!=null && name.length()>0 && !Objects.equals(libUser.getName(),name))
        {
            libUser.setName(name);
        }

        if(email!=null && email.length()>0 && !Objects.equals(libUser.getUsername(),email))
        {
            Optional<LibUser> libUserOptional = libUserRepository.findLibUserByUsername(email);
            if(libUserOptional.isPresent())
            {
                throw new IllegalStateException("email taken");
            }
            libUser.setUsername(email);
        }

        libUserRepository.save(libUser);

    }
}
