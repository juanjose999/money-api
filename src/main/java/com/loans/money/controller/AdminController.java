package com.loans.money.controller;

import com.loans.money.dto.admin.AdminDto;
import com.loans.money.dto.admin.AdminMapper;
import com.loans.money.dto.admin.AdminResponseDto;
import com.loans.money.entity.Admin;
import com.loans.money.entity.Client;
import com.loans.money.repository.admin.AdminRepository;
import com.loans.money.repository.client.ClientRepository;
import com.loans.money.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    private final AdminService adminService;

    @GetMapping
    public ResponseEntity<List<AdminResponseDto>> allAdmins(){
        return ResponseEntity.ok(adminService.allAdmins());
    }
    @GetMapping("{id}")
    public ResponseEntity<AdminResponseDto> findClientById(@PathVariable Integer id){
        return ResponseEntity.of(adminService.findAdmin(id));
    }
    @PostMapping("/save")
    public ResponseEntity<AdminResponseDto> saveAdmin(@RequestBody AdminDto adminDto){
        return ResponseEntity.ok(adminService.saveAdmin(adminDto));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<AdminResponseDto> updateAdmin(@PathVariable int id, @RequestBody AdminDto adminDto){
        return ResponseEntity.of(adminService.updateAdmin(id, adminDto));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteAdmin(@PathVariable int id){
        return ResponseEntity.ok(adminService.deleteAdminById(id));
    }

}
