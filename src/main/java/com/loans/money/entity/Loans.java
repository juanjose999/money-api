package com.loans.money.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Loans {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idloan;
    @ManyToOne(targetEntity = Clients.class, fetch = FetchType.LAZY)
    private Clients clientData;
    private double amountmoney;
    private double interest;
    private boolean isactive;
    @OneToMany(targetEntity = Payments.class, fetch = FetchType.LAZY, mappedBy = "loan")
    private List<Payments> payment;
}
