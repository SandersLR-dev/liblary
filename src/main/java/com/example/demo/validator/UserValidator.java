package com.example.demo.validator;

import com.example.demo.entity.LibUser;
import com.example.demo.repository.LibUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class UserValidator {

    private final LibUserRepository libUserRepository;

    public void validateIfUserExists(LibUser libUser)
    {
        Optional<LibUser> user = libUserRepository.findLibUserByUsername(libUser.getUsername());

        if(user.isPresent())
        {
            boolean equals = user.get().getId().equals(libUser.getId());
            if(!equals)
            {
                throw new IllegalStateException("Inny ");
            }
        }


    }


}
