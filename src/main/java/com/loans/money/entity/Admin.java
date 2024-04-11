package com.loans.money.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static com.loans.money.entity.Role.ADMIN;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_admin;
    private String full_name;
    private String password_admin;
    private Enum<Role> role = ADMIN;
    @OneToMany(targetEntity = Client.class,fetch = FetchType.LAZY, mappedBy = "admin")
    private List<Client> client_list;

    public Admin(String fullname, String passwordadmin) {
        this.full_name = fullname;
        this.password_admin = passwordadmin;
        this.role=getRole();
        client_list = new ArrayList<>();
    }
    public static void addClient(Client client){
        Client clientNew = client;
        //client_list.add(clientNew);
    }

}
