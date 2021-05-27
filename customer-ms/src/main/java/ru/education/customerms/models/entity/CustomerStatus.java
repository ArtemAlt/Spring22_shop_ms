package ru.education.customerms.models.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="customer_status")
public class CustomerStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="type")
    private String type;

}
