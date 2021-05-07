package ru.education.eurekafeignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.education.core.model.dto.*;

import java.util.List;


@FeignClient("product-ms")
@RequestMapping("/api/v1/products")
public interface FeignProductControllerInterface{
    @GetMapping("/find/{name}")
    ProductDTO findByName(String name);

    @GetMapping("/findId/{id}")
    ProductDTO findByID(Long id);

    @PostMapping("/find/")
    List<ProductDTO> findProductsByIDS(TwoProductIdsDto dto);

    @GetMapping("/description/{name}")
    @ResponseStatus(HttpStatus.OK)
    ProductDescriptionDTO findDescriptionByName(String name);

    @GetMapping("/product_item/{name}")
    ProductItemDTO findProductItemByName(String name);

    @GetMapping("/total_information/{name}")
    ProductTotalInformationDTO findALLInfoByName(String name);

    @GetMapping("/products_in_category/{name}")
    CategoryDTO findALLProductsByCategoryName(String name);
}
