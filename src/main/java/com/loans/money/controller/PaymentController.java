package com.loans.money.controller;

import com.loans.money.dto.payment.PaymentDto;
import com.loans.money.dto.payment.PaymentResponseDto;
import com.loans.money.entity.Payment;
import com.loans.money.service.payment.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/payment")
@CrossOrigin("*")
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<PaymentResponseDto>> allPayments (){
        return ResponseEntity.ok(paymentService.allPayment());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponseDto> findPayment (@PathVariable Long id){
        return ResponseEntity.of(paymentService.findPaymentById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<PaymentResponseDto> savePayment(@RequestBody Map<String, Object> requestBody) {
        try {
            Long loanId = ((Number) requestBody.get("loanId")).longValue();
            Double amountPayment = ((Number) requestBody.get("amount_payment")).doubleValue();

            PaymentResponseDto savedPayment = paymentService.savePayment(loanId, amountPayment);

            return new ResponseEntity<>(savedPayment, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Error saving payment: " + e.getMessage());
            return new ResponseEntity("Error in saving payment.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PaymentResponseDto> updatePayment(@PathVariable Long id, @RequestBody PaymentDto paymentDto){
        return  ResponseEntity.ok(paymentService.updatePayment(id, paymentDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        return ResponseEntity.ok(paymentService.deletePayment(id));
    }

}
