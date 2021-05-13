package com.example.demo.repository;

import com.example.demo.entity.Book;
import com.example.demo.entity.Borrow;
import com.example.demo.entity.LibUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authentication.jaas.JaasPasswordCallbackHandler;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow,Long> {


    Optional<Borrow> findBorrowById(Long id);
    Optional<Borrow> findBorrowByLibUser(LibUser libUser);
    Optional<Borrow> findBorrowByBook(Book book);
}
