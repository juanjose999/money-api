package com.loans.money.service.admin;

import com.loans.money.dto.admin.AdminDto;
import com.loans.money.dto.admin.AdminMapper;
import com.loans.money.dto.admin.AdminResponseDto;
import com.loans.money.entity.Admin;
import com.loans.money.entity.Client;
import com.loans.money.repository.admin.AdminRepository;
import com.loans.money.repository.client.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService{

    private final AdminRepository adminRepository;
    private final ClientRepository clientRepository;

    @Override
    public List<AdminResponseDto> allAdmins() {
        List<Admin> allAdmins = adminRepository.allAdmins();
        List<AdminResponseDto> adminResponseDtos = new ArrayList<>();
        for (Admin admin : allAdmins){
            List<Client> clientList = clientRepository.findAdminById(admin.getId_admin());
            adminResponseDtos.add(AdminMapper.adminToAdminResponseDto(admin,clientList));
        }
        return adminResponseDtos;
    }

    public Optional<AdminResponseDto> findAdmin(int id) {
        Admin adminFind = adminRepository.findAdmin(id).orElse(null);
        if(adminFind!=null){
            List<Client> clientList = clientRepository.allClients();
            List<Client> findClients =  clientRepository.findAdminById(adminFind.getId_admin());
            return Optional.of(AdminMapper.adminToAdminResponseDto(adminFind,findClients));
        }else return Optional.empty();
   }

    @Override
   public AdminResponseDto saveAdmin(AdminDto adminDto) {
        return AdminMapper.adminToAdminResponseDto(adminRepository.saveAdmin(AdminMapper.adminDtoToAdmin(adminDto)));
    }

   @Override
    public Optional<AdminResponseDto> updateAdmin(int id, AdminDto adminDto) {
        Optional<Admin> updatedAdmin = adminRepository.updateAdmin(id, AdminMapper.adminDtoToAdmin(adminDto));
        return updatedAdmin.map(AdminMapper::adminToAdminResponseDto);
    }

    @Override
    public Boolean deleteAdminById(int id) {
        return adminRepository.deleteAdminById(id);
    }
}
