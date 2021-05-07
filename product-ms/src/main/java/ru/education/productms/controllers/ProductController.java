package ru.education.productms.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.education.core.model.dto.*;
import ru.education.productms.service.ProductService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/products")
@EnableAspectJAutoProxy
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/find/{name}") // ищет точное соответствие
    public ProductDTO findByName(@PathVariable String name) {
        return service.findProductByNameDTO(name);
    }

    @GetMapping("/findId/{id}")
    public ProductDTO findByID(@PathVariable Long id) {
        System.out.println("Request find by id -"+id);
        return service.findProductByID(id);
    }

    @PostMapping("/find/")
    public List<ProductDTO> findProductsByIDS(@RequestBody TwoProductIdsDto dto) {
        return service.findProductsByIDS(dto);
    }

    @GetMapping("/description/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDescriptionDTO findDescriptionByName(@PathVariable String name) {
        return service.findDescriptionByProductName(name);
    }
    @GetMapping("/product_item/{name}")
    public ProductItemDTO findProductItemByName(@PathVariable String name) {
        return service.findProductItemByProductName(name);
    }
    @GetMapping("/total_information/{name}")
    public ProductTotalInformationDTO findALLInfoByName(@PathVariable String name) {
        return service.findAllInformationByProductName(name);
    }
    @GetMapping("/products_in_category/{name}")
    public CategoryDTO findALLProductsByCategoryName(@PathVariable String name) {
        return service.findALLProductsByCategoryName(name);
    }
}