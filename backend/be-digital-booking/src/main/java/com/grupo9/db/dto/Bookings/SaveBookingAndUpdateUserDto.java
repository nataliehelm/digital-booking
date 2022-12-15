package com.grupo9.db.dto.Bookings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class SaveBookingAndUpdateUserDto {
    @NotNull(message = "starting time is mandatory")
    private Date starting_time;
    @NotNull(message = "starting date is mandatory")
    private Date starting_date;
    @NotNull(message = "ending date is mandatory")
    private Date ending_date;
    @NotNull(message = "product is mandatory")
    private Long productId;
    @NotNull(message = "user is mandatory")
    private Long userId;
    @NotNull(message = "locationId is mandatory")
    private Long locationId;
}
