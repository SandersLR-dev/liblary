package com.example.demo.repository;

import com.example.demo.entity.LibUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibUserRepository extends JpaRepository<LibUser,Long> {

    //@Query("SELECT s FROM LibUser s WHERE s.email = ?1")
    Optional<LibUser> findLibUserByUsername(String username);


}
