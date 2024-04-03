package com.loans.money.repository;

import com.loans.money.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryAdminJpa extends JpaRepository<Admin, Integer> {
}
