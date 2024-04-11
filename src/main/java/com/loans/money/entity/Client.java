package com.loans.money.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static com.loans.money.entity.Role.VISITOR;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_client;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String phone_number;
    private Enum<Role> role = VISITOR;
    @JsonManagedReference
    @OneToMany(targetEntity = Loan.class,fetch = FetchType.EAGER, mappedBy = "client_data")
    private List<Loan> loans_list;
    @ManyToOne(targetEntity = Admin.class)
    @JoinColumn(name = "admin_id")
    @JsonIgnore
    private Admin admin;

    public Client(String firstName, String lastName, String phone_number, List<Loan> loan_List) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone_number = phone_number;
        this.role = getRole();
        this.loans_list = loan_List;
        this.admin = getAdmin();
    }
}
