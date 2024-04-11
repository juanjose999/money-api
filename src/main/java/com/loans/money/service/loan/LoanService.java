package com.loans.money.service.loan;

import com.loans.money.dto.loan.LoanDto;
import com.loans.money.dto.loan.LoanResponseDto;
import com.loans.money.entity.Client;
import com.loans.money.entity.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanService {
    List<LoanResponseDto> allLoans();
    Optional<LoanResponseDto> findLoanById(Long id);
    LoanResponseDto saveLoan(LoanDto loanDto);
    LoanResponseDto updateLoan(Long id, LoanDto loanDto);
    Boolean deleteLoanById(Long id);
}
