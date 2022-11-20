package com.grupo9.db.dto.Product;

import com.grupo9.db.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetProductWithBookingsDto {

    private Product product;
    private List<GetBookedDatesDto> bookings;

}
