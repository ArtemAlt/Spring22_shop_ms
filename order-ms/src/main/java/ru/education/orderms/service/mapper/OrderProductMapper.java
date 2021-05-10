package ru.education.orderms.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.education.core.model.dto.OrderProductDTO;
import ru.education.orderms.entity.OrderProduct;

@Component
public class OrderProductMapper {
    ModelMapper mapper = new ModelMapper();

    public OrderProductDTO toDTO(OrderProduct op) {
        mapper.typeMap(OrderProduct.class, OrderProductDTO.class);
        return mapper.map(op, OrderProductDTO.class);
    }


}
