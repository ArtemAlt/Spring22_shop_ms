package ru.education.eurekafeignclient.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.education.core.model.dto.*;

import java.util.List;


@FeignClient("product-ms")
public interface FeignProductControllerInterface{

    @GetMapping("/product/api/v1/products/find/{name}")
    ProductDTO findByName(@PathVariable(value = "name") String name);

    @GetMapping("/product/api/v1/products/findId/{id}")
    ProductDTO findByID(@PathVariable(value = "id") Long id);

    @PostMapping("/product/api/v1/products/find/")
    List<ProductDTO> findProductsByIDS(@RequestBody TwoProductIdsDto dto);

    @GetMapping("/product/api/v1/products/description/{name}")
    @ResponseStatus(HttpStatus.OK)
    ProductDescriptionDTO findDescriptionByName(@PathVariable(value = "name") String name);

    @GetMapping("/product/api/v1/products/product-item/{name}")
    ProductItemDTO findProductItemByName(@PathVariable(value = "name") String name);

    @GetMapping("/product/api/v1/products/total-information/{name}")
    ProductTotalInformationDTO findALLInfoByName(@PathVariable(value = "name") String name);

    @GetMapping("/product/api/v1/products/products-in-category/{name}")
    CategoryDTO findALLProductsByCategoryName(@PathVariable(value = "name") String name);
}
