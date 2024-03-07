package com.Butchery.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor @Getter @Setter @ToString
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    @Column(name = "c_password")
    private String password;
    @Column(name = "c_name")
    private String name;
    private String surname;
    @Column(name = "admin_privilege")
    private boolean admin;
}
