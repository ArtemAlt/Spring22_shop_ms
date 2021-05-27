package ru.education.orderms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import ru.education.core.model.dto.ProductDTO;
import ru.education.core.model.dto.ProductItemDTO;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="shop_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_status")
    private OrderStatus status;

    @Column(name = "id_customer")
    private Long customerId;

    @ManyToMany
    @JoinTable(
            name = "order_items",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<OrderProduct> productIdList;
}
