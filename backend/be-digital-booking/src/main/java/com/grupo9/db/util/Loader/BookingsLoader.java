package com.grupo9.db.util.Loader;

import com.grupo9.db.model.Booking;
import com.grupo9.db.model.Location;
import com.grupo9.db.model.Product;
import com.grupo9.db.model.User;
import com.grupo9.db.repository.*;
import com.grupo9.db.util.Loader.Products.Product1;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class BookingsLoader {
    IBookingRepository iBookingRepository;
    IProductRepository iProductRepository;
    IUserRepository iUserRepository;

    public BookingsLoader(IBookingRepository iBookingRepository, IProductRepository iProductRepository, IUserRepository iUserRepository) {
        this.iBookingRepository = iBookingRepository;
        this.iProductRepository = iProductRepository;
        this.iUserRepository = iUserRepository;
    }

    public void Loader() {
        Product producto = iProductRepository.findById(1L).get();
        User user = iUserRepository.findById(Long.valueOf(1)).get();

        String starting_time_string = "2022-11-20T22:00:03.000Z";
        TemporalAccessor ta0 = DateTimeFormatter.ISO_INSTANT.parse(starting_time_string);
        Instant i0 = Instant.from(ta0);
        Date starting_time = Date.from(i0);

        String starting_date_string = "2022-11-20T05:00:00.000Z";
        TemporalAccessor ta = DateTimeFormatter.ISO_INSTANT.parse(starting_date_string);
        Instant i = Instant.from(ta);
        Date starting_date = Date.from(i);

        String ending_date_string = "2022-11-25T05:00:00.000Z";
        TemporalAccessor ta2 = DateTimeFormatter.ISO_INSTANT.parse(ending_date_string);
        Instant i2 = Instant.from(ta2);
        Date ending_date = Date.from(i2);


        Booking booking1 = new Booking(starting_time, starting_date, ending_date, producto, user);
        iBookingRepository.save(booking1);
    }
}
