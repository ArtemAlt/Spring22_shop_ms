package ru.education.eurekafeignclient.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.education.core.model.dto.*;

import java.util.List;


@FeignClient("product-ms")
public interface FeignProductControllerInterface{

    @GetMapping("/products/api/v1/product/find/{name}")
    ProductDTO findByName(@PathVariable(value = "name") String name);

    @GetMapping("/products/api/v1/product/findId/{id}")
    ProductDTO findByID(@PathVariable(value = "id") Long id);

    @PostMapping("/products/api/v1/product/find/")
    List<ProductDTO> findProductsByIDS(@RequestBody TwoProductIdsDto dto);

    @GetMapping("/products/api/v1/product/description/{name}")
    @ResponseStatus(HttpStatus.OK)
    ProductDescriptionDTO findDescriptionByName(@PathVariable(value = "name") String name);

    @GetMapping("/products/api/v1/product/product-item/{name}")
    ProductItemDTO findProductItemByName(@PathVariable(value = "name") String name);

    @GetMapping("/products/api/v1/product/total-information/{name}")
    ProductTotalInformationDTO findALLInfoByName(@PathVariable(value = "name") String name);

    @GetMapping("/products/api/v1/product/products-in-category/{name}")
    CategoryDTO findALLProductsByCategoryName(@PathVariable(value = "name") String name);
}
