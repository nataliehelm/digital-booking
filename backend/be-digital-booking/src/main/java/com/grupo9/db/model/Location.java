package com.grupo9.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "location_sequence")
    @EqualsAndHashCode.Include
    private Long id;
    @NotEmpty(message = "Province is mandatory")
    private String province_name;
    @NotEmpty(message = "City is mandatory")
    private String city_name;
    @NotEmpty(message = "Country is mandatory")
    private String country_name;

    @CreationTimestamp
    @JsonIgnore
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @JsonIgnore
    @Column(name = "updated_at")
    private Date updated_at;

    public Location(String province_name, String city_name, String country_name) {
        this.province_name = province_name;
        this.city_name = city_name;
        this.country_name = country_name;
    }
}
