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
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shopId;

    private String shopCategory;
    private String shopName;
    private String customers;
    private String shopStatus;
    private String leaseStatus;

    @ManyToOne
    @JoinColumn(name = "mall_id")
    private Mall mall;

    @OneToOne(mappedBy = "shop", cascade = CascadeType.ALL)
    @JsonIgnore
    private ShopOwner shopOwner;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Employee> employees;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrderDetails> orderDetails;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Item> items;
}
