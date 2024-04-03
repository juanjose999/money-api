package com.loans.money.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idadmin;
    private String fullnameadmin;
    private String passwordadmin;
    @OneToMany(targetEntity = Clients.class,fetch = FetchType.LAZY, mappedBy = "admin")
    private List<Clients> clientsList;
}
