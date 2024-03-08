package com.Butchery.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor @Getter @Setter
public class MeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "meat_type")
    private String type;
    @Column(name = "meat_description")
    private String description;
    private int stock;
    private float price;
}
