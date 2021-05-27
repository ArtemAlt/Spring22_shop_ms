package ru.education.orderms.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.education.core.model.dto.*;
import ru.education.orderms.service.OrderService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService service;

    @GetMapping("/{id}")
    public List<OrderDTO> getAllOrderByCustomerId(@PathVariable(name = "id") Long id) {
        return service.findAllOrdersByCustomerId(id);
    }

    @GetMapping("/")
    public List<OrderDTO> getAllOrder() {
        return service.findAll();
    }

    @PostMapping("/save/{id}")
    public String createOrderByCustomerId(@PathVariable(name = "id") Long id,
                                          @RequestBody List<OrderProductDTO> list) {
        return service.createOrder(id, list);
    }

    @GetMapping("/details/{id}")
    public List<OrderProductDTO> getOrderDetailsByOrderId(@PathVariable(name= "id") Long id){
        return service.getDetailsByOrderId(id);
    }

    @GetMapping("/dto")
    public OrderProductDTO getDTO() {
        OrderProductDTO dto = new OrderProductDTO();
        dto.setProductId(5L);
        dto.setQuantity(3);
        return dto;
    }

    @GetMapping("/dto-list")
    public List<OrderProductDTO> getDTOList() {
        List<OrderProductDTO> dtoList = new ArrayList<>();
        OrderProductDTO dto = new OrderProductDTO();
        dto.setProductId(5L);
        dto.setQuantity(3);
        dtoList.add(dto);
        OrderProductDTO dto1 = new OrderProductDTO();
        dto.setProductId(4L);
        dto.setQuantity(7);
        dtoList.add(dto1);
        return dtoList;
    }


}
