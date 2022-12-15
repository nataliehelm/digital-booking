package com.grupo9.db.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "booking_sequence")
    private Long id;

    @Temporal(TemporalType.TIME)
    @NotNull(message = "starting_time is mandatory")
    @Column(name = "starting_time", nullable=false)
    private Date starting_time;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "starting_date is mandatory")
    @Column(name = "starting_date", nullable=false)
    private Date starting_date;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "ending_date is mandatory")
    @Column(name = "ending_date", nullable=false)
    private Date ending_date;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Booking(Date starting_time, Date starting_date, Date ending_date, Product product, User user) {
        this.starting_time = starting_time;
        this.starting_date = starting_date;
        this.ending_date = ending_date;
        this.product = product;
        this.user = user;
    }
}
