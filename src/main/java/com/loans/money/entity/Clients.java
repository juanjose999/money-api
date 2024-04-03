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
public class Clients {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idclient;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    @OneToMany(targetEntity = Loans.class,fetch = FetchType.LAZY, mappedBy = "clientData")
    private List<Loans> loanslist;
    @ManyToOne(targetEntity = Admin.class)
    private Admin admin;
}
