package com.grupo9.db.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "user", uniqueConstraints = {
    @UniqueConstraint(columnNames = "email")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_sequence")
    @EqualsAndHashCode.Include
    private Long id;

    @NotEmpty(message = "name is mandatory")
    @Column(name = "name", nullable=false)
    private String name;

    @NotEmpty(message = "lastname is mandatory")
    @Column(name = "lastname", nullable=false)
    private String lastname;

    @NotEmpty(message = "email is mandatory")
    @Email(message = "email with wrong format")
    @Column(name = "email", nullable=false)
    private String email;

    @NotEmpty(message = "password is mandatory")
    @Size(min = 6)
    @Column(name = "password", nullable=false)
    private String password;

    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id")
    @Enumerated(EnumType.ORDINAL)
    private Role roles;

    public User(String name, String lastname, String email, String password) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }
}