package com.loans.money.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Loan {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_loan;
    @JsonBackReference
    @ManyToOne(targetEntity = Client.class, fetch = FetchType.EAGER)
    private Client client_data;
    private BigDecimal loan;
    private String date_loan;
    private double interest;
    private double debt_interests_month;
    private Integer months_debt;
    private BigDecimal debt_total;
    private boolean is_active = true;
    @OneToMany(targetEntity = Payment.class, fetch = FetchType.LAZY, mappedBy = "loan")
    private List<Payment> payments;

    public Loan( BigDecimal loan, double interest, String date_loan) {
        this.client_data = getClient_data();
        this.loan = loan;
        this.interest = interest;
        this.date_loan = date_loan;
        this.debt_interests_month = getDebt_interests_month();
        this.months_debt = getMonths_debt();
        this.debt_total = getDebt_total();
        this.payments = getPayments();
        this.is_active = true;
    }
}
