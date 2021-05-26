package com.library.service.impl;

import com.library.domain.dto.user.UserDto;
import com.library.domain.entity.User;
import com.library.domain.exception.UserNotFoundException;
import com.library.repository.UserRepository;
import com.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public void addUser(UserDto userDto) {
        User user = User.builder()
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .login(userDto.getLogin())
                .dob(userDto.getDateOfBirth())
                .role(userDto.getRole())
                .hashPassword(passwordEncoder.encode(userDto.getPassword())).build();
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(String id) {

        boolean exists = userRepository.existsById(id);
        if (!exists) {
            throw new IllegalArgumentException("User with id " + id + " doesn't exists");
        }
        userRepository.deleteById(id);
    }

    @Transactional
    public void updateUser(String id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        user.setDob(userDto.getDateOfBirth());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        userRepository.save(user);
    }
}
