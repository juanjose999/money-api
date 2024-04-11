package com.loans.money.repository.admin;

import com.loans.money.entity.Admin;
import com.loans.money.entity.Client;
import com.loans.money.repository.client.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
@RequiredArgsConstructor
public class AdminRepository implements RepositoryAdmin{

    private final RepositoryJpaAdmin repositoryJpaAdmin;

    @Override
    public List<Admin> allAdmins() {
        return repositoryJpaAdmin.findAll();
    }

    @Override
    public Optional<Admin> findAdmin(int id) {
        return repositoryJpaAdmin.findById(id);
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        return repositoryJpaAdmin.save(admin);
    }

    @Override
    public Optional<Admin> updateAdmin(int id, Admin admin) {
        return findAdmin(id).map(a -> {
            a.setFull_name(admin.getFull_name());
            a.setPassword_admin(admin.getPassword_admin());
            a.setClient_list(admin.getClient_list());
            return repositoryJpaAdmin.save(a);
        });
    }

    @Override
    public Boolean deleteAdminById(int id) {
        return findAdmin(id).map(admin -> {
            repositoryJpaAdmin.delete(admin);
            return true;
        }).orElse(false);
    }

}
