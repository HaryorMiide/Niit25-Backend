package com.javalord.reactapp.spring_react_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @OneToOne(fetch = FetchType.EAGER)
    private Cart cart;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();
    @OneToMany(fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();


}
