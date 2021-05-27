package ru.education.orderms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.education.orderms.entity.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

   List<Order>findAllByCustomerId(Long id);
   Order findByCustomerId(Long id);
}
