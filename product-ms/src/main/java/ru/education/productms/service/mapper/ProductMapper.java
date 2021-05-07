package ru.education.productms.service.mapper;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.education.core.model.dto.ProductDTO;
import ru.education.productms.models.Entity.Product;

@Component
public class ProductMapper {
    ModelMapper mapper = new ModelMapper();

    public ProductDTO toDTO(Product product) {
        mapper.typeMap(Product.class, ProductDTO.class)
                .addMapping(Product::getProductCategoryName, ProductDTO::setCategory);
        return mapper.map(product, ProductDTO.class);
    }
}
