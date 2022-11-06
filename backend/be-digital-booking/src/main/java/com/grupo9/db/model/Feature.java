package com.grupo9.db.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "feature")
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "feature_sequence")
    private Long id;
    @NotEmpty(message = "Feature is mandatory")
    @Column(name = "name", nullable = false, length = 80)
    private String featureName;
    @NotEmpty(message = "Icon is mandatory")
    @Column(name="icon", nullable = false, length = 255)
    private String iconUrl;

    @ManyToMany(targetEntity=Product.class)
    private Set productSet;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updated_at;

    public Feature() {
    }

    public Feature(String featureName, String iconUrl) {
        this.featureName = featureName;
        this.iconUrl = iconUrl;
    }

    public Feature(String featureName, String iconUrl, Set productSet) {
        this.featureName = featureName;
        this.iconUrl = iconUrl;
        this.productSet = productSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "id=" + id +
                ", featureName='" + featureName + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
