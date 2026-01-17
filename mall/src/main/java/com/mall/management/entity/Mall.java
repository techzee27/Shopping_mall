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
public class Mall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mallName;
    private String location;
    private String categories;

    @OneToMany(mappedBy = "mall", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Shop> shops;

    @OneToOne(mappedBy = "mall", cascade = CascadeType.ALL)
    @JsonIgnore
    private MallAdmin mallAdmin;
}
