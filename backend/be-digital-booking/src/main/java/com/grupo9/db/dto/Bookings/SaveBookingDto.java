package com.grupo9.db.dto.Bookings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class SaveBookingDto {
    @NotEmpty(message = "starting time is mandatory")
    private Date starting_time;
    @NotEmpty(message = "starting date is mandatory")
    private Date starting_date;
    @NotEmpty(message = "ending date is mandatory")
    private Date ending_date;
    @NotEmpty(message = "product is mandatory")
    private Long productId;
    @NotEmpty(message = "user is mandatory")
    private Long userId;
}
