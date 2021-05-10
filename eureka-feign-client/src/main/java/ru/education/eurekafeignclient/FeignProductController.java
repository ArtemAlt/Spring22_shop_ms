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

    @RequestMapping("/product/api/v1/products/find/{name}")
    public ProductDTO findByName(@PathVariable(value = "name") String name) {
        return productController.findByName(name);
    }

    @RequestMapping("/product/api/v1/products/findId/{id}")
    public ProductDTO findByID(@PathVariable(value ="id") Long id) {
        return productController.findByID(id);
    }

    @RequestMapping("/product/api/v1/products/find/")
    public List<ProductDTO> findProductsByIDS(@RequestBody TwoProductIdsDto dto) {
        return productController.findProductsByIDS(dto);
    }

    @RequestMapping("/product/api/v1/products/description/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDescriptionDTO findDescriptionByName(@PathVariable(value ="name") String name) {
        return productController.findDescriptionByName(name);
    }

    @RequestMapping("/product/api/v1/products/product-item/{name}")
    public ProductItemDTO findProductItemByName(@PathVariable(value ="name") String name) {
        return productController.findProductItemByName(name);
    }

    @GetMapping("/product/api/v1/products/total-information/{name}")
    public ProductTotalInformationDTO findALLInfoByName(@PathVariable(value ="name") String name) {
        return productController.findALLInfoByName(name);
    }

    @GetMapping("/product/api/v1/products/products-in-category/{name}")
    public CategoryDTO findALLProductsByCategoryName(@PathVariable(value ="name") String name){
        return productController.findALLProductsByCategoryName(name);
    }

}
