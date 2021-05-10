package ru.education.productms.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.education.core.model.dto.*;
import ru.education.productms.interfaces.ProductControllerInterface;
import ru.education.productms.service.ProductService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/products")
@EnableAspectJAutoProxy
public class ProductController implements ProductControllerInterface {
    @Autowired
    private ProductService service;

    @GetMapping("/find/{name}") // ищет точное соответствие
    public ProductDTO findByName(@PathVariable(value = "name") String name) {
        return service.findProductByNameDTO(name);
    }

    @GetMapping("/findId/{id}")
    public ProductDTO findByID(@PathVariable(value ="id") Long id) {
        System.out.println("Request find by id -"+id);
        return service.findProductByID(id);
    }

    @PostMapping("/find/")
    public List<ProductDTO> findProductsByIDS(@RequestBody TwoProductIdsDto dto) {
        return service.findProductsByIDS(dto);
    }

    @GetMapping("/description/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDescriptionDTO findDescriptionByName(@PathVariable (value = "name")  String name) {
        return service.findDescriptionByProductName(name);
    }
    @GetMapping("/product-item/{name}")
    public ProductItemDTO findProductItemByName(@PathVariable(value = "name")  String name) {
        return service.findProductItemByProductName(name);
    }
    @GetMapping("/total-information/{name}")
    public ProductTotalInformationDTO findALLInfoByName(@PathVariable(value = "name")  String name) {
        return service.findAllInformationByProductName(name);
    }
    @GetMapping("/products-in-category/{name}")
    public CategoryDTO findALLProductsByCategoryName(@PathVariable(value = "name")  String name) {
        return service.findALLProductsByCategoryName(name);
    }
}