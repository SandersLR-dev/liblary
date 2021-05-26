package com.library.domain.mapper;

import com.library.domain.dto.author.AuthorDto;
import com.library.domain.dto.checkout.CheckoutDto;
import com.library.domain.entity.Author;
import com.library.domain.entity.Checkout;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CheckoutMapper {

    public CheckoutDto toCheckoutDto(Checkout checkout) {
        if (Objects.isNull(checkout)) {
            return null;
        }
        return CheckoutDto.builder()
                .book(checkout.getBook())
                .user(checkout.getUser())
                .checkoutDate(checkout.getCheckoutDate())
                .returnDate(checkout.getReturnDate()).build();

    }

    public List<CheckoutDto> toCheckoutDtoList(List<Checkout> checkoutList) {
        List<CheckoutDto> resultList = new ArrayList<>();
        if (Objects.isNull(checkoutList)) {
            return resultList;
        }
        for (Checkout checkout : checkoutList) {
            resultList.add(toCheckoutDto(checkout));
        }
        return resultList;
    }
}
