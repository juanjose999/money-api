package com.loans.money.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payments {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idPayment;
    private LocalDateTime datePayment;
    @ManyToOne(targetEntity = Loans.class, fetch = FetchType.LAZY)
    private Loans loan;
    private double totalpayment;
    @ManyToOne(targetEntity = Bill.class)
    private Bill bill;
}
