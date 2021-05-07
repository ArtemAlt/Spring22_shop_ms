package ru.education.core.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TwoProductIdsDto {
    private Long firstId;
    private Long secondId;
}
