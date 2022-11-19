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
        System.out.println(producto);
        /*User user = iUserRepository.findById(Long.valueOf(1)).get();

        String patternHr = "HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(patternHr);
        Date startingHr = sdf.parse("22:00:03");

        String s = "2022-11-20T05:00:00.000Z";
        TemporalAccessor ta = DateTimeFormatter.ISO_INSTANT.parse(s);
        Instant i = Instant.from(ta);
        Date d = Date.from(i);

        String s2 = "2022-11-25T05:00:00.000Z";
        TemporalAccessor ta2 = DateTimeFormatter.ISO_INSTANT.parse(s2);
        Instant i2 = Instant.from(ta2);
        Date d2 = Date.from(i2);


        Booking booking1 = new Booking(startingHr, d, d2, producto, user);
        iBookingRepository.save(booking1);*/
    }
}
