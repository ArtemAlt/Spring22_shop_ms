package ru.education.core.model.dto;

import lombok.Data;

@Data
public class AddCustomerDTO {

    private String name;

    private String password;

    private Long role;
}
