package com.loans.money.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Bill {
    @Id
    private long idbill;
    @OneToMany(targetEntity = Payment.class, fetch = FetchType.LAZY, mappedBy = "bill")
    private List<Payment> datapayment;
}
