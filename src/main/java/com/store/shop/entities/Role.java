package com.store.shop.entities;

import jakarta.persistence.*;
import lombok.Data;


import java.util.Set;

@Entity
@Data
@Table(name = "role")
public class Role
{
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    //private Set<User> users;



}
