package com.loans.money.repository.admin;

import com.loans.money.entity.Admin;
import com.loans.money.entity.Client;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RepositoryAdmin {
    List<Admin> allAdmins();
    Optional<Admin> findAdmin(int id);
    Admin saveAdmin(Admin admin);
    Optional<Admin> updateAdmin(int id, Admin admin);
    Boolean deleteAdminById(int id);
}
