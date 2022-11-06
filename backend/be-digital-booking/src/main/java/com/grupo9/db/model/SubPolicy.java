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
@Table(name = "subpolicy")
public class SubPolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "subpolicy_sequence")
    @EqualsAndHashCode.Include
    private Long id;

    @NotEmpty(message = "Description is mandatory")
    @Column(name = "description", nullable=false)
    private String description;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "policy_id", nullable = false)
//    @JsonBackReference
//    private Policy policy;


    @CreationTimestamp
    @JsonIgnore
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @JsonIgnore
    @Column(name = "updated_at")
    private Date updated_at;

    public SubPolicy(String description, Policy policy) {
        this.description = description;
//        this.policy = policy;
    }
}
