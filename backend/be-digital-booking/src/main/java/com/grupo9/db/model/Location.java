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
    @NotEmpty
    private String name;
    @NotEmpty
    private String iso_id;
    @NotEmpty
    private String short_name;
    @NotEmpty
    private String category;
    @NotEmpty
    private String iso_name;
    @NotEmpty
    private String country;

    @CreationTimestamp
    @JsonIgnore
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @JsonIgnore
    @Column(name = "updated_at")
    private Date updated_at;

    public Location(String name, String iso_id, String short_name, String category, String iso_name, String country) {
        this.name = name;
        this.iso_id = iso_id;
        this.short_name = short_name;
        this.category = category;
        this.iso_name = iso_name;
        this.country = country;
    }
}
