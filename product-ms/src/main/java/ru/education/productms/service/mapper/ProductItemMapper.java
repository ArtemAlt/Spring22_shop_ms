package ru.education.productms.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.education.core.model.dto.ProductItemDTO;
import ru.education.productms.models.Entity.ProductItem;

@Component
public class ProductItemMapper {
    ModelMapper mapper = new ModelMapper();

    public ProductItemDTO toDTO(ProductItem item) {
        mapper.typeMap(ProductItem.class, ProductItemDTO.class)
                .addMapping(ProductItem::getProductName, ProductItemDTO::setProduct);
        return mapper.map(item, ProductItemDTO.class);
    }
}
