package ru.education.productms.service.mapper;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.education.core.model.dto.CategoryDTO;
import ru.education.productms.models.Entity.Category;

@Component
public class CategoryMapper {
    ModelMapper mapper = new ModelMapper();

    public CategoryDTO toDTO(Category category) {
        mapper.typeMap(Category.class, CategoryDTO.class)
                .addMapping(Category::getProductListName, CategoryDTO::setProductList);
        return mapper.map(category, CategoryDTO.class);
    }
}
