package ru.education.core.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductTotalInformationDTO {
    private Long id;
    private String name;
    private List<String> category;
    private Double price;
    private int quantity;
    private String description;
    private String storage;

}
