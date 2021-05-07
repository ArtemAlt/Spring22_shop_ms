package ru.education.eurekafeignclient;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.education.core.model.dto.*;

import javax.annotation.PostConstruct;
import java.util.List;




@RequiredArgsConstructor
@Controller
public class FeignProductController {
    private final FeignProductControllerInterface productController;

    @GetMapping("/find/{name}")
    public ProductDTO findByName(@PathVariable String name) {
        return productController.findByName(name);
    }

    @GetMapping("/findId/{id}")
    public ProductDTO findByID(@PathVariable Long id) {
        return productController.findByID(id);
    }

    @PostMapping("/find/")
    public List<ProductDTO> findProductsByIDS(@RequestBody TwoProductIdsDto dto) {
        return productController.findProductsByIDS(dto);
    }

    @GetMapping("/description/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDescriptionDTO findDescriptionByName(@PathVariable String name) {
        return productController.findDescriptionByName(name);
    }

    @GetMapping("/product_item/{name}")
    public ProductItemDTO findProductItemByName(@PathVariable String name) {
        return productController.findProductItemByName(name);
    }

    @GetMapping("/total_information/{name}")
    public ProductTotalInformationDTO findALLInfoByName(@PathVariable String name) {
        return productController.findALLInfoByName(name);
    }

    @GetMapping("/products_in_category/{name}")
    public CategoryDTO findALLProductsByCategoryName(@PathVariable String name){
        return productController.findALLProductsByCategoryName(name);
    }

}
