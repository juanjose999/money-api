package com.loans.money.dto.loan;

import com.loans.money.entity.Loan;

public class LoanMapper {

    public static Loan loanDtoToLoan(LoanDto loanDto){
        return new Loan(
                loanDto.getLoan(),
                loanDto.getInterest(),
                loanDto.getDate_loan()
        );
    }

    public static LoanResponseDto loanToLoanResponseDto (Loan loan){
        return new LoanResponseDto(
                loan.getLoan(),
                loan.getInterest(),
                loan.getDate_loan()
        );
    }
}
