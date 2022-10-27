package com.grupo9.db.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "location_sequence")
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
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updated_at;

    public Location() {
    }

    public Location(Long id, String name, String iso_id, String short_name, String category, String iso_name, Date created_at, Date updated_at, String country) {
        this.id = id;
        this.name = name;
        this.iso_id = iso_id;
        this.short_name = short_name;
        this.category = category;
        this.iso_name = iso_name;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.country = country;
    }

    public Location(String name, String iso_id, String short_name, String category, String iso_name, String country) {
        this.name = name;
        this.iso_id = iso_id;
        this.short_name = short_name;
        this.category = category;
        this.iso_name = iso_name;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso_id() {
        return iso_id;
    }

    public void setIso_id(String iso_id) {
        this.iso_id = iso_id;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIso_name() {
        return iso_name;
    }

    public void setIso_name(String iso_name) {
        this.iso_name = iso_name;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", iso_id='" + iso_id + '\'' +
                ", short_name='" + short_name + '\'' +
                ", category='" + category + '\'' +
                ", iso_name='" + iso_name + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
