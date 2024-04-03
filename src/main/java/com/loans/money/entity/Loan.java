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
public class Loan {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idloan;
    @ManyToOne(targetEntity = Client.class, fetch = FetchType.LAZY)
    private Client clientData;
    private double amountmoney;
    private double interest;
    private boolean isactive;
    @OneToMany(targetEntity = Payment.class, fetch = FetchType.LAZY, mappedBy = "loan")
    private List<Payment> payment;
}
