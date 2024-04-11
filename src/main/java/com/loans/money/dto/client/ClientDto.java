package com.loans.money.dto.client;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.loans.money.dto.loan.LoanDto;
import com.loans.money.entity.Admin;
import com.loans.money.entity.Loan;
import com.loans.money.entity.Role;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static com.loans.money.entity.Role.VISITOR;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private String firstName;
    private String lastName;
    private String phone_number;
    private List<Loan> loans_list;
    private Admin admin;

    public ClientDto(String firstName, String lastName, String phone_number, List<Loan> loan_List) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone_number = phone_number;
        this.loans_list = loan_List;
    }

}
