package ru.education.productms.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.education.core.model.dto.*;
import ru.education.productms.models.Entity.*;
import ru.education.productms.repository.CategoryRepository;
import ru.education.productms.repository.ProductDescriptionRepository;
import ru.education.productms.repository.ProductItemRepository;
import ru.education.productms.repository.ProductRepository;
import ru.education.productms.service.mapper.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private ProductMapper mapper;
    @Autowired
    private ProductDescriptionRepository descriptionRepository;
    @Autowired
    private ProductDescriptionMapper descriptionMapper;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private ProductItemMapper productItemMapper;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductTotalInformationMapper productTotalInfoMapper;

    public Product findProductByName(String name) {
        return repository.findByName(name);
    }

    public ProductDTO findProductByNameDTO(String name) {
        Product response = repository.findByName(name);
        System.out.println(response.getName());
        return mapper.toDTO(response);
    }

    public ProductDescriptionDTO findDescriptionByProductName(String name) {
        Product product = repository.findByName(name);
        return descriptionMapper.toDTO(descriptionRepository.findDistinctByProduct(product));
    }

    public ProductItemDTO findProductItemByProductName(String name){
        Product product = repository.findByName(name);
       return productItemMapper.toDTO(productItemRepository.findProductItemByProduct(product));
    }

    public ProductTotalInformationDTO findAllInformationByProductName(String name) {
        Product product = repository.findByName(name);
        ProductDescription pd = descriptionRepository.findDistinctByProduct(product);
        ProductItem pi = productItemRepository.findProductItemByProduct(product);
        return productTotalInfoMapper.toDTO(new ProductTotalInformation(product,pd,pi));
    }


    public CategoryDTO findALLProductsByCategoryName(String name) {
       Category category= categoryRepository.findByName(name);
       return categoryMapper.toDTO(category);
    }

    public ProductDTO findProductByID(Long id) {
        Product product = repository.findById(id).orElseThrow(
                ()-> new NoSuchElementException("Product Id not found"));
        return mapper.toDTO(product);
    }

    public List<ProductDTO> findProductsByIDS(TwoProductIdsDto dto) {
        List<Product> products = repository.findAllByIdBetween(dto.getFirstId(), dto.getSecondId());
        return products.stream().map(
                product ->mapper.toDTO(product))
                .collect(Collectors.toList());
    }
}
