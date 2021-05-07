package ru.education.productms.service.mapper;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.education.core.model.dto.ProductTotalInformationDTO;
import ru.education.productms.models.Entity.ProductTotalInformation;

@Component
public class ProductTotalInformationMapper {
    ModelMapper mapper = new ModelMapper();

    public ProductTotalInformationDTO toDTO(ProductTotalInformation info) {
        mapper.typeMap(ProductTotalInformation.class, ProductTotalInformationDTO.class);
        return mapper.map(info, ProductTotalInformationDTO.class);
    }
}
