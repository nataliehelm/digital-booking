package com.grupo9.db.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "product_sequence")
    private Long id;
    @NotEmpty(message = "Product name is mandatory")
    @Column(name = "productName", nullable = false, length = 80)
    private String productName;
    @NotEmpty(message = "Category is mandatory")
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @NotEmpty(message = "Image is mandatory")
    @ManyToMany
    @JoinColumn(name = "image_id")
    private Image image;

    @NotEmpty(message = "Address is mandatory")
    @Column(name = "address", nullable = false, length = 80)
    private String address;

    @NotEmpty(message = "Score is mandatory")
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

    public Product(String productName, Category category, String address, char score) {
        this.productName = productName;
        this.category = category;
        this.address = address;
        this.score = score;
    }

    public Product(String productName, Category category, Image image, String address, char score, Date created_at, Date updated_at) {
        this.productName = productName;
        this.category = category;
        this.image = image;
        this.address = address;
        this.score = score;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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
