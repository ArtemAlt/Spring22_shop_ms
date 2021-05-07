package ru.education.productms.models.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductItemDTO {
    private Long id;
    private Double price;
    private  int quantity ;
    private String product;
}
