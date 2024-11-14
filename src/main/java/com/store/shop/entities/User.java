package com.store.shop.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;


import java.util.Collection;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3, message = "Need to be more than 3 symbols")
    @Column(unique = true)
    private String userName;
    @Size(min = 3, message = "Need to be more than 3 symbols")
    private String password;
    @Transient
    private String passwordConfirm;
//    @ManyToMany(fetch = FetchType.EAGER)
//    private Set<Role> roles;

    private String role;


}
