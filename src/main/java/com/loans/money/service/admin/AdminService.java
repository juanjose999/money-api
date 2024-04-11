package com.loans.money.service.admin;

import com.loans.money.dto.admin.AdminDto;
import com.loans.money.dto.admin.AdminResponseDto;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    List<AdminResponseDto> allAdmins();
    Optional<AdminResponseDto> findAdmin(int id);
    AdminResponseDto saveAdmin(AdminDto adminDto);
    Optional<AdminResponseDto> updateAdmin(int id, AdminDto adminDto);
    Boolean deleteAdminById(int id);

}
