package ru.education.orderms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.education.orderms.entity.OrderStatus;

public interface OrderStatusRepository extends JpaRepository<OrderStatus,Long> {
    OrderStatus findByStatus(String status);
}
