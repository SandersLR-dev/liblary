package com.example.demo.controller;


import com.example.demo.entity.Borrow;
import com.example.demo.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "lib/borrow")
public class BorrowController {

    private  final BorrowService borrowService;

    @Autowired
    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @GetMapping
    public List<Borrow> getBorrow(){
        return borrowService.getBorrow();
    }

    @PostMapping
    public void addNewBorrow(@RequestBody Borrow borrow)
    {
        borrowService.addNewBorrow(borrow);
    }

    @DeleteMapping(path = "{borrowId}")
    public void deleteBorrow(@PathVariable("borrowId") Long borrowId)
    {
        borrowService.deleteBorrow(borrowId);
    }

}
