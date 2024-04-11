package com.loans.money.repository.loan;

import com.loans.money.entity.Client;
import com.loans.money.entity.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanRepository {
    List<Loan> allLoans();
    Optional<Loan> findLoanById(Long id);
    Loan saveLoan(Loan loan);
    Loan updateLoan(Long id, Loan loan);
    void updateDetailsLoan(Client client, List<Loan> loanList);
    Boolean deleteLoanById(Long id);
}
