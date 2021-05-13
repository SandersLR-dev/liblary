package com.example.demo.service;


import com.example.demo.entity.Book;
import com.example.demo.entity.Borrow;
import com.example.demo.entity.LibUser;
import com.example.demo.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class BorrowService {

    private final BorrowRepository borrowRepository;

    @Autowired
    public BorrowService(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    public List<Borrow> getBorrow()
    {
        return borrowRepository.findAll();
    }

    public void addNewBorrow(Borrow borrow)
    {
        borrowRepository.save(borrow);
    }

    public void deleteBorrow(Long borrowId)
    {
        boolean exists=borrowRepository.existsById(borrowId);

        if(!exists)
        {
            throw new IllegalStateException("borrow with id "+ borrowId + " doesn't exists");
        }

        borrowRepository.deleteById(borrowId);
    }

    public void updateBorrow(Long borrowId, LibUser libUser, Book book, LocalDate borrowDate,LocalDate returnDate)
    {
        Borrow borrow = borrowRepository.findBorrowById(borrowId).orElseThrow(()->new IllegalStateException("borrow with id "+ borrowId+" doesn't exists"));

        if(libUser!=null && !Objects.equals(borrow.getLibUser(),libUser))
        {
            borrow.setLibUser(libUser);
        }

        if(book!=null && !Objects.equals(borrow.getBook(),book))
        {
            borrow.setBook(book);
        }
        if(borrowDate!=null && !Objects.equals(borrow.getBorrowDate(),borrowDate))
        {
            borrow.setBorrowDate(borrowDate);
        }
        if(returnDate!=null && !Objects.equals(borrow.getReturnDate(),returnDate))
        {
            borrow.setReturnDate(returnDate);
        }

        borrowRepository.save(borrow);
    }

}
