package com.grupo9.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "product_sequence")
    @EqualsAndHashCode.Include
    private Long id;

    @NotEmpty(message = "Name is mandatory")
    @Column(name = "name", nullable=false, length=100)
    private String name;

    @Column(name = "distance_to_nearest_tourist_site", length=100)
    private String distance_to_nearest_tourist_site;

    @Column(name = "ranking", nullable=false)
    @Min(0)
    @Max(5)
    private double ranking = 0.0;

    @Column(name = "score",nullable=false)
    @Min(0)
    @Max(10)
    private double score = 0.0;

    @Column(name = "description_title")
    @NotEmpty(message = "Description Title is mandatory")
    private String description_title;

    @Column(name = "description",columnDefinition="LONGTEXT")
    @NotEmpty(message = "Description is mandatory")
    private String description;

    @Column(name = "coordinates")
    @ElementCollection
    @NotEmpty(message = "Coordinates is mandatory")
    private List<Double> coordinates = new ArrayList<>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(optional = false)
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToMany()
    @JoinTable(name = "product_feature", joinColumns = { @JoinColumn(name = "product_id") }, inverseJoinColumns = {
            @JoinColumn(name = "feature_id") })
    private List<Feature> features = new ArrayList<>();

    @ManyToMany()
    @JoinTable(name = "product_policy", joinColumns = { @JoinColumn(name = "product_id") }, inverseJoinColumns = {
            @JoinColumn(name = "policy_id") })
    private List<Policy> policies = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @OrderBy("id ASC")
    @JsonManagedReference
    private Set<Image> images;

    @CreationTimestamp
    @JsonIgnore
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @JsonIgnore
    @Column(name = "updated_at")
    private Date updated_at;

    public Product(String name, String distance_to_nearest_tourist_site, Category category, Location location, List<Feature> features) {
        this.name = name;
        this.category = category;
        this.location = location;
        this.features = features;
    }

    public Product(String name, String distance_to_nearest_tourist_site, double ranking, double score, String description_title, String description, @NotEmpty(message = "Coordinates is mandatory") List<Double> coordinates, Category category, Location location, List<Feature> features
            , List<Policy> policies
    ) {
        this.name = name;
        this.distance_to_nearest_tourist_site = distance_to_nearest_tourist_site;
        this.ranking = ranking;
        this.score = score;
        this.description_title = description_title;
        this.description = description;
        this.coordinates = coordinates;
        this.category = category;
        this.location = location;
        this.features = features;
        this.policies = policies;
    }
}