package ru.education.productms.interfaces;

import ru.education.core.model.dto.*;

import java.util.List;

public interface ProductControllerInterface {
    ProductDTO findByName(String name);
    ProductDTO findByID(Long id);
    List<ProductDTO> findProductsByIDS(TwoProductIdsDto dto);
    ProductDescriptionDTO findDescriptionByName(String name);
    ProductItemDTO findProductItemByName(String name);
    ProductTotalInformationDTO findALLInfoByName(String name);
    CategoryDTO findALLProductsByCategoryName(String name);

}
