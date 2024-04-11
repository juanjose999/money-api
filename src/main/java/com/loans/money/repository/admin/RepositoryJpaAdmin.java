package com.loans.money.repository.admin;

import com.loans.money.entity.Admin;
import com.loans.money.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryJpaAdmin extends JpaRepository<Admin, Integer> {


}
