package ru.education.core.model.dto;

import lombok.Data;

@Data
public class OrderItemDto {

    private String productTitle;

    private int quantity;

    private int pricePerProduct;

    private int price;

}
