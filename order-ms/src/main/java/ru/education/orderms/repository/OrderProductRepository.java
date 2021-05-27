package ru.education.orderms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.education.orderms.entity.Order;
import ru.education.orderms.entity.OrderProduct;

import java.util.List;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
    List<OrderProduct> findAllByOrderNumber(Long id);
}
