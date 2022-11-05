package com.grupo9.db.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.util.Date;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "category_sequence")
    private Long id;
    @NotEmpty(message = "Title is mandatory")
    @Column(name = "title", nullable=false, length=80)
    private String title;
    @NotEmpty(message = "Description is mandatory")
    @Column(name = "description", nullable=false, length=200)
    private String description;
    private String image_url;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updated_at;

    public Category() {
    }

    public Category(String title, String description, String image_url) {
        this.title = title;
        this.description = description;
        this.image_url = image_url;
    }

    public Category(Long id, String title, String description, String image_url) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image_url = image_url;
    }

    public Category(Long id, String title, String description, String image_url, Date createdAt, Date updatedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image_url = image_url;
        this.created_at = createdAt;
        this.updated_at = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Date getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Date createdAt) {
        this.created_at = createdAt;
    }

    public Date getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updated_at = updatedAt;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}
