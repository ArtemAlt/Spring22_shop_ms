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
//todo - как лучше тут сделать? оставить тут или вынести как отдельные сущности или вообще через Storge сделать
    @Column(name = "price")
    private Double price;

    @Column(name ="quantity")
    private Integer quantity;


    //@OneToOne
    //@Column(name="storage_id")
    //private Storage storage

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public String getProductName() {
        return this.product.getName();
    }
}
