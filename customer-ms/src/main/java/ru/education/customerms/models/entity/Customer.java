package ru.education.customerms.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="customer")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name="status_id")
    private CustomerStatus status;

    @OneToOne
    @JoinColumn(name = "account_id")
    private ShopAccount account;

    @OneToMany (mappedBy = "name")
    private List<Role> role;

    public void addRoleCustomer (Role role){
        this.role.add(role);
    }

//    @OneToMany(mappedBy = "currentCustomer")
//    private List<Orders> ordersList;
}