package ru.education.customerms.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="shop_account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="amount")
    private Double amount;

    @OneToOne
    @JoinColumn(name="status")
    private ShopAccountStatus status;


}
