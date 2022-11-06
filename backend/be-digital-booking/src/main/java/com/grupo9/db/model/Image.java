package com.grupo9.db.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "image_sequence")
    @EqualsAndHashCode.Include
    private Long id;

    @NotEmpty(message = "Title is mandatory")
    @Column(name = "title", nullable=false, length=80)
    private String title;

    @NotEmpty(message = "URL is mandatory")
    @Column(name = "url", nullable=false)
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    @JsonBackReference
    private Product product;

    @CreationTimestamp
    @JsonIgnore
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @JsonIgnore
    @Column(name = "updated_at")
    private Date updated_at;

    public Image(String title, String url, Product product) {
        this.title = title;
        this.url = url;
        this.product = product;
    }
}
