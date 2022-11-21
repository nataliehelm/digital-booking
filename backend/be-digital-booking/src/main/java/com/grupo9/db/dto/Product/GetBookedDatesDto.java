package com.grupo9.db.dto.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetBookedDatesDto {

    private Long id;
    private Date starting_time;
    private Date starting_date;
    private Date ending_date;
    private List<LocalDate> booked_dates;

    public GetBookedDatesDto() {
    }
}
