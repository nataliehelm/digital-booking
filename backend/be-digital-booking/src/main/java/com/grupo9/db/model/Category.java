package com.grupo9.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "category_sequence")
    @EqualsAndHashCode.Include
    private Long id;
    @NotEmpty(message = "Name is mandatory")
    @Column(name = "name", nullable=false, length=80)
    private String name;
    @NotEmpty(message = "Description is mandatory")
    @Column(name = "description", nullable=false, length=200)
    private String description;
    @NotEmpty(message = "Image is mandatory")
    private String image_url;

    @CreationTimestamp
    @JsonIgnore
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @JsonIgnore
    @Column(name = "updated_at")
    private Date updated_at;

    public Category(String name, String description, String image_url) {
        this.name = name;
        this.description = description;
        this.image_url = image_url;
    }
}
