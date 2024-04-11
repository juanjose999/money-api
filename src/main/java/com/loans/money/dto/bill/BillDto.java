package com.loans.money.dto.bill;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.loans.money.entity.Payment;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
public class BillDto {

    private LocalDate dateBill;
    private Long id_loan;
    private Long id_client;
    private String full_name_client;
    private BigDecimal loan_initial;
    private Double amount_payment;
    private BigDecimal debt_actually;
    @ManyToOne(targetEntity = Payment.class)
    @JsonIgnore
    private Payment payment;

    public BillDto( Payment payment) {
        this.dateBill = getDateBill();
        this.id_loan = getId_loan();
        this.id_client = getId_client();
        this.full_name_client = getFull_name_client();
        this.loan_initial = getLoan_initial();
        this.amount_payment = getAmount_payment();
        this.debt_actually = getDebt_actually();
        this.payment = getPayment();
    }
    public LocalDate getDateBill(){
        return LocalDate.now();
    }

}
