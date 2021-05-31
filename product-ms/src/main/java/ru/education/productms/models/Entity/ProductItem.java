package ru.education.productms.models.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product_item")
@AllArgsConstructor
@NoArgsConstructor
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price")
    private Double price;

    @Column(name ="quantity")
    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public String getProductName() {
        return this.product.getName();
    }
}
