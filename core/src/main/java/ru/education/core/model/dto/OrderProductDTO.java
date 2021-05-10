package ru.education.core.model.dto;


import lombok.Data;

@Data
public class OrderProductDTO {
    private Long productId;
    private int quantity;
}
