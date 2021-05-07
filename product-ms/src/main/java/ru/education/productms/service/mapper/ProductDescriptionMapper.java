package ru.education.productms.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.education.core.model.dto.ProductDescriptionDTO;
import ru.education.productms.models.Entity.ProductDescription;

@Component
public class ProductDescriptionMapper {
    ModelMapper mapper = new ModelMapper();

    public ProductDescriptionDTO toDTO(ProductDescription description) {
        mapper.typeMap(ProductDescription.class, ProductDescriptionDTO.class)
                .addMapping(ProductDescription::getProductName, ProductDescriptionDTO::setProduct);
        return mapper.map(description, ProductDescriptionDTO.class);
    }
}
