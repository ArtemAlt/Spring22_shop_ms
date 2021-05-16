package ru.education.eurekafeignclient;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.education.core.model.dto.*;
import ru.education.eurekafeignclient.interfaces.FeignProductControllerInterface;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FeignProductController {
    private final FeignProductControllerInterface productController;

    @RequestMapping("/products/api/v1/product/find/{name}")
    public ProductDTO findByName(@PathVariable(value = "name") String name) {
        return productController.findByName(name);
    }

    @RequestMapping("/products/api/v1/product/findId/{id}")
    public ProductDTO findByID(@PathVariable(value ="id") Long id) {
        return productController.findByID(id);
    }

    @RequestMapping("/products/api/v1/product/find/")
    public List<ProductDTO> findProductsByIDS(@RequestBody TwoProductIdsDto dto) {
        return productController.findProductsByIDS(dto);
    }

    @RequestMapping("/products/api/v1/product/description/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDescriptionDTO findDescriptionByName(@PathVariable(value ="name") String name) {
        return productController.findDescriptionByName(name);
    }

    @RequestMapping("/products/api/v1/product/product-item/{name}")
    public ProductItemDTO findProductItemByName(@PathVariable(value ="name") String name) {
        return productController.findProductItemByName(name);
    }

    @GetMapping("/products/api/v1/product/total-information/{name}")
    public ProductTotalInformationDTO findALLInfoByName(@PathVariable(value ="name") String name) {
        return productController.findALLInfoByName(name);
    }

    @GetMapping("/products/api/v1/product/products-in-category/{name}")
    public CategoryDTO findALLProductsByCategoryName(@PathVariable(value ="name") String name){
        return productController.findALLProductsByCategoryName(name);
    }

}
