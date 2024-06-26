package com.loans.money.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Bill {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateBill;
    private Long id_loan;
    private Long id_client;
    private String full_name_client;
    private BigDecimal loan_initial;
    private BigDecimal debt_before_payment;
    private Double amount_payment;
    private BigDecimal debt_actually;
    @ManyToOne(targetEntity = Payment.class)
    @JsonIgnore
    private Payment payment;

    public Bill( Payment payment) {
        this.dateBill = getDateBill();
        this.id_loan = getId_loan();
        this.id_client = getId_client();
        this.full_name_client = getFull_name_client();
        this.loan_initial = getLoan_initial();
        this.debt_before_payment = getDebt_before_payment();
        this.amount_payment = getAmount_payment();
        this.debt_actually = getDebt_actually();
        this.payment = getPayment();
    }
    public LocalDate getDateBill(){
        return LocalDate.now();
    }
}
