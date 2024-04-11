package com.loans.money.controller;

import com.loans.money.dto.loan.LoanDto;
import com.loans.money.dto.loan.LoanResponseDto;
import com.loans.money.entity.Loan;
import com.loans.money.service.loan.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/loan")
@CrossOrigin("*")
public class LoanController {

    private final LoanService loanService;
    @GetMapping
    public ResponseEntity<List<LoanResponseDto>> allLoans(){
        return ResponseEntity.ok(loanService.allLoans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanResponseDto> findLoanById(@PathVariable Long id){
        return ResponseEntity.of(loanService.findLoanById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<LoanResponseDto> saveNewLoan(@RequestBody LoanDto loanDto){
        return ResponseEntity.ok(loanService.saveLoan(loanDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LoanResponseDto> updateLoan(@PathVariable Long id, @RequestBody LoanDto loanDto){
        return ResponseEntity.ok(loanService.updateLoan(id, loanDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteLoanById(@PathVariable Long id){
        return ResponseEntity.ok(loanService.deleteLoanById(id));
    }

}
