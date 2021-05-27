package ru.education.eurekafeignclient.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.education.core.model.dto.OrderDTO;
import ru.education.core.model.dto.OrderProductDTO;

import java.util.List;

@FeignClient("order-ms")
public interface FeignOrderControllerInterface {

    @GetMapping("/orders/api/v1/order/{id}")
    List<OrderDTO> getAllOrderByCustomerId(@PathVariable(value= "id") Long id);

    @GetMapping("/orders/api/v1/order/")
    List<OrderDTO> getAllOrder();

    @PostMapping("/orders/api/v1/order/save/{id}")
    String createOrderByCustomerId(@PathVariable(value= "id") Long id,
                                   @RequestBody List<OrderProductDTO> list);

    @GetMapping("/orders/api/v1/order/details/{id}")
    List<OrderProductDTO> getOrderDetailsByOrderId(@PathVariable(value= "id") Long id);

    @GetMapping("/orders/api/v1/order/dto")
    OrderProductDTO getDTO();

    @GetMapping("/orders/api/v1/order/dto-list")
    List<OrderProductDTO> getDTOList();

}
