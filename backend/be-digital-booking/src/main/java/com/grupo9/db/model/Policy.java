package com.grupo9.db.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
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
@Table(name = "policy")
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "policy_sequence")
    @EqualsAndHashCode.Include
    private Long id;

    @NotEmpty(message = "Title is mandatory")
    @Column(name = "title", nullable=false, length=80)
    private String title;

//    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
//    @OrderBy("id ASC")
//    @JsonManagedReference
//    private Set<SubPolicy> subPolicies;

//    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
//    @OrderBy("id ASC")
//    @JsonManagedReference
//    private Set<SubPolicy> subPolicies;

    @CreationTimestamp
    @JsonIgnore
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @JsonIgnore
    @Column(name = "updated_at")
    private Date updated_at;

    public Policy(String title) {
        this.title = title;
    }
}
