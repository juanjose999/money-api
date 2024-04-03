package com.loans.money.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idPayment;
    private LocalDateTime datePayment;
    @ManyToOne(targetEntity = Loan.class, fetch = FetchType.LAZY)
    private Loan loan;
    private double totalpayment;
    @ManyToOne(targetEntity = Bill.class)
    private Bill bill;
}
