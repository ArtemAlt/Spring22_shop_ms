package ru.education.eurekafeignclient;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.education.core.model.dto.*;
import ru.education.eurekafeignclient.interfaces.FeignOrderControllerInterface;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FeignOrderController {
    private final FeignOrderControllerInterface orderController;

    @RequestMapping("/orders/api/v1/order/{id}")
    public List<OrderDTO> getAllOrderByCustomerId(@PathVariable(value = "id") Long id) {
        return orderController.getAllOrderByCustomerId(id);
    }

    @RequestMapping("/orders/api/v1/order/")
    public List<OrderDTO> getAllOrder() {
        return orderController.getAllOrder();
    }

    @RequestMapping("/orders/api/v1/order/save/{id}")
    public String createOrderByCustomerId(@PathVariable(value= "id") Long id,
                                          @RequestBody List<OrderProductDTO> list) {
        return orderController.createOrderByCustomerId(id, list);
    }

    @RequestMapping("/orders/api/v1/order/details/{id}")
    public List<OrderProductDTO> getOrderDetailsByOrderId(@PathVariable(value= "id") Long id){
        return orderController.getOrderDetailsByOrderId(id);
    }

    @RequestMapping("/orders/api/v1/order/dto")
    public OrderProductDTO getDTO() {
        return orderController.getDTO();
    }

    @RequestMapping("/orders/api/v1/order/dto-list")
    public List<OrderProductDTO> getDTOList() {
        return orderController.getDTOList();
    }

}
