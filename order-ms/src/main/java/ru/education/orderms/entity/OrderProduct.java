package ru.education.orderms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.education.core.model.dto.OrderProductDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="order_items")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="order_number")
    private Long orderNumber;

    @Column(name="customer_id")
    private Long customerId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "quantity")
    private int quantity;


}
