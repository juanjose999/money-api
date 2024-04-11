package com.loans.money.controller;

import com.loans.money.dto.bill.BillDto;
import com.loans.money.dto.bill.BillResponseDto;
import com.loans.money.entity.Bill;
import com.loans.money.service.bill.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bill")
@CrossOrigin("*")
public class BillController {

    private final BillService billService;

    @GetMapping
    public ResponseEntity<List<BillResponseDto>> allBills(){
        return ResponseEntity.ok(billService.allBill());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillResponseDto> findBillById(@PathVariable  Long id){
        return ResponseEntity.of(billService.findBillById(id));
    }
    @PostMapping("/save")
    public ResponseEntity<BillResponseDto> saveBill(@RequestBody BillDto billDto){
        return ResponseEntity.ok(billService.saveBill(billDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        return ResponseEntity.ok(billService.deleteBillById(id));
    }
}
