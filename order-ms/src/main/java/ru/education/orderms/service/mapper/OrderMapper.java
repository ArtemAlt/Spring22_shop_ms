package ru.education.orderms.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.education.core.model.dto.OrderDTO;
import ru.education.orderms.entity.Order;

@Component
public class OrderMapper {
    ModelMapper mapper = new ModelMapper();

    public OrderDTO toDTO(Order order) {
        mapper.typeMap(Order.class, OrderDTO.class)
                .addMapping(Order::getCustomerId, OrderDTO::setName);
        return mapper.map(order, OrderDTO.class);
    }


}
