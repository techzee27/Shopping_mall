package com.mall.management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String phone;
    private String email;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrderDetails> orderDetails;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
