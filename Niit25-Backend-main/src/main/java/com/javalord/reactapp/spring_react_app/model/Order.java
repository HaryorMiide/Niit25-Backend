package com.javalord.reactapp.spring_react_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    private int id;
    @OneToMany(fetch = FetchType.EAGER)
    private List<OrderItem> orderItems = new ArrayList<>();
    private LocalDateTime localDateTime;
}
