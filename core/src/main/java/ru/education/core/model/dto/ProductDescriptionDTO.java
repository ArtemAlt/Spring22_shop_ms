package ru.education.core.model.dto;

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
