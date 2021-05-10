package ru.education.orderms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.education.core.model.dto.OrderDTO;
import ru.education.core.model.dto.OrderProductDTO;
import ru.education.orderms.entity.Order;
import ru.education.orderms.entity.OrderProduct;
import ru.education.orderms.repository.OrderProductRepository;
import ru.education.orderms.repository.OrderRepository;
import ru.education.orderms.repository.OrderStatusRepository;
import ru.education.orderms.service.mapper.OrderMapper;
import ru.education.orderms.service.mapper.OrderProductMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final OrderProductMapper orderProductMapper;
    private final OrderProductRepository orderProductRepository;
    private final OrderStatusRepository orderStatusRepository;

    public List<OrderDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO).collect(Collectors.toList());
    }

    public List<OrderDTO> findAllOrdersByCustomerId(Long id) {
        return repository.findAllByCustomerId(id).stream()
                .map(mapper::toDTO).collect(Collectors.toList());
    }

    @Transactional
    public String createOrder(Long id, List<OrderProductDTO> orderProductList) {
        Order newOrder = new Order();
        newOrder.setCustomerId(id);
        newOrder.setStatus(orderStatusRepository.findByStatus("IN_CARD"));
        repository.save(newOrder);
        Order saveOrder = repository.findByCustomerId(id);
        Long saveOrderNumber = saveOrder.getId();
        Long saveOrderCustomerId = saveOrder.getCustomerId();
        List<OrderProduct> order = new ArrayList<>();
        for (OrderProductDTO dto : orderProductList
        ) {
            OrderProduct product = new OrderProduct();
            product.setOrderNumber(saveOrderNumber);
            product.setCustomerId(saveOrderCustomerId);
            product.setProductId(dto.getProductId());
            product.setQuantity(dto.getQuantity());
            order.add(product);
        }
        orderProductRepository.saveAll(order);
        return "OK";
    }

    public List<OrderProductDTO> getDetailsByOrderId(Long id) {
        return orderProductRepository.findAllByOrderNumber(id)
                .stream().map(orderProductMapper::toDTO)
                .collect(Collectors.toList());
    }
}
