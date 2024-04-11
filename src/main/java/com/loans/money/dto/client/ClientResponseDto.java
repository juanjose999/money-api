package com.loans.money.dto.client;

import com.loans.money.dto.loan.LoanResponseDto;
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
@NoArgsConstructor
public class ClientResponseDto {

    private String firstName;
    private String lastName;
    private String phone_number;
    private List<LoanResponseDto> loans_list;

    public ClientResponseDto(String firstName, String lastName, String phone_number, List<LoanResponseDto> loan_List) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone_number = phone_number;
        this.loans_list = loan_List;
    }
}
