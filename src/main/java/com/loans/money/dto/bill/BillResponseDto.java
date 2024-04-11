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
public class BillResponseDto {

    private LocalDate dateBill;
    private String full_name_client;
    private BigDecimal loan_initial;
    private Double amount_payment;
    private BigDecimal debt_total_actually;
    @JsonIgnore
    private Payment payment;

    public BillResponseDto( Payment payment) {
        this.dateBill = getDateBill();
        this.full_name_client = getFull_name_client();
        this.loan_initial = getLoan_initial();
        this.amount_payment = getAmount_payment();
        this.debt_total_actually = getDebt_total_actually();
    }

}
