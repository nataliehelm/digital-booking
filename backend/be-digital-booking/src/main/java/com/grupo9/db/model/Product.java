package com.grupo9.db.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "product_sequence")
    private Long id;
    @NotEmpty(message = "Product name is mandatory")
    @Column(name = "productName", nullable = false, length = 80)
    private String productName;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToMany(targetEntity=Feature.class)
    private Set featureSet;

    @NotEmpty(message = "Address is mandatory")
    @Column(name = "address", nullable = false, length = 80)
    private String address;

    @ElementCollection
    @Column(name = "coordinates")
    private List<String> coordinates = new ArrayList<String>();

    @Column(name = "score", nullable = false, length = 5)
    private char score;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updated_at;

    public Product() {
    }

    public Product(String productName, Category category, Location location, Set featureSet, String address, ArrayList<String> coordinates, char score) {
        this.productName = productName;
        this.category = category;
        this.location = location;
        this.featureSet = featureSet;
        this.address = address;
        this.coordinates = coordinates;
        this.score = score;
    }
    public Product(String productName, Category category, Location location, String address, ArrayList<String> coordinates, char score) {
        this.productName = productName;
        this.category = category;
        this.location = location;
        this.address = address;
        this.coordinates = coordinates;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set getFeatureSet() {
        return featureSet;
    }

    public void setFeatureSet(Set featureSet) {
        this.featureSet = featureSet;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ArrayList<String> coordinates) {
        this.coordinates = coordinates;
    }

    public char getScore() {
        return score;
    }

    public void setScore(char score) {
        this.score = score;
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", category=" + category +
                ", address='" + address + '\'' +
                ", score=" + score +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
