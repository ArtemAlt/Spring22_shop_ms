package ru.education.productms.models.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductTotalInformation {
    private Long id;
    private String name;
    private List<String> category;
    private Double price;
    private int quantity;
    private String description;
    private String storage;

    public ProductTotalInformation(Product product, ProductDescription pd, ProductItem pi) {
        this.id = product.getId();
        this.name= pd.getProductName();
        this.category=product.getProductCategoryName();
        this.price= pi.getPrice();
        this.quantity= pi.getQuantity();
        this.description= pd.getDescription();
        this.storage="UNKNOWN";
    }
}
