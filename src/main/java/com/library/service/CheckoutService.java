package com.library.service;

import com.library.domain.dto.checkout.CheckoutDto;

import java.util.List;

public interface CheckoutService {

    void createCheckout(CheckoutDto checkoutDto);

    List<CheckoutDto> getCheckoutList(Integer page);

    void deleteCheckout(String id);
}
