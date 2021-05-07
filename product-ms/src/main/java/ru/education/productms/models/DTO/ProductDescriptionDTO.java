package ru.education.productms.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDescriptionDTO {
    private Long id;
    private String description;
    private String product;
}
