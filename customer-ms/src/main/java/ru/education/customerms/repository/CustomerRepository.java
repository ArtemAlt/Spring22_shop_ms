package ru.education.customerms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.education.customerms.models.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByName(String name);
}
