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
@Table(name = "feature")
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "feature_sequence")
    @EqualsAndHashCode.Include
    private Long id;

    @NotEmpty(message = "Name is mandatory")
    @Column(name = "name", nullable=false, length=80)
    private String name;

    @NotEmpty(message = "Icon is mandatory")
    @Column(name = "icon", nullable=false, length=80)
    private String icon;

    @CreationTimestamp
    @JsonIgnore
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @JsonIgnore
    @Column(name = "updated_at")
    private Date updated_at;

    public Feature(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }
}
