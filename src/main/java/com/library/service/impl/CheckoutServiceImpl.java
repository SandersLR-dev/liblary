package com.library.service.impl;

import com.library.domain.dto.checkout.CheckoutDto;
import com.library.domain.entity.Checkout;
import com.library.repository.CheckoutRepository;
import com.library.service.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private CheckoutRepository checkoutRepository;

    @Override
    public void createCheckout(CheckoutDto checkoutDto) {

        Checkout checkout = Checkout.builder()
                .book(checkoutDto.getBook())
                .user(checkoutDto.getUser())
                .checkoutDate(checkoutDto.getCheckoutDate())
                .returnDate(checkoutDto.getReturnDate()).build();
        checkoutRepository.save(checkout);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CheckoutDto> getCheckoutList(Integer page) {
        return null;
    }

    @Override
    @Transactional
    public void deleteCheckout(String id) {
        Checkout checkout= checkoutRepository.getOne(id);
        checkoutRepository.delete(checkout);
    }
}
