package com.loans.money.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_payment;
    private LocalDateTime localDateTime;
    @ManyToOne(targetEntity = Loan.class, fetch = FetchType.LAZY)
    @JsonIgnore
    private Loan loan;
    private BigDecimal debt_before_payment;
    private Double amount_Payment;
    private BigDecimal debt_total_actually;
    @OneToMany(targetEntity = Bill.class,fetch = FetchType.EAGER, mappedBy = "payment")
    private List<Bill> bill;

    public Payment( Loan loan, Double amount_Payment) {
        this.localDateTime = LocalDateTime.now();
        this.loan = loan;
        this.debt_before_payment = getDebt_before_payment();
        this.amount_Payment = amount_Payment;
        this.debt_total_actually = getDebt_total_actually();
        this.bill = new ArrayList<>();
    }


}
