package ru.education.productms.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.education.core.model.dto.*;
import ru.education.productms.models.Entity.*;
import ru.education.productms.repository.CategoryRepository;
import ru.education.productms.repository.ProductDescriptionRepository;
import ru.education.productms.repository.ProductItemRepository;
import ru.education.productms.repository.ProductRepository;
import ru.education.productms.service.mapper.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {ProductService.class,
        ProductMapper.class,
        ProductDescriptionMapper.class,
        ProductItemMapper.class,
        CategoryMapper.class,
        ProductTotalInformationMapper.class})
class ProductServiceTest {
    @Autowired
    private ProductService service;
    @MockBean
    private ProductRepository repository;
    @MockBean
    private ProductDescriptionRepository descriptionRepository;
    @MockBean
    private ProductItemRepository productItemRepository;
    @MockBean
    private CategoryRepository categoryRepository;

    @Test
    public void findProductByNameTest() {
        Category demoCategory = new Category();
        demoCategory.setName("Groсery");
        List<Category> listDemoCategory = new ArrayList<>();
        listDemoCategory.add(demoCategory);
        Product demoProduct = new Product();
        demoProduct.setName("Butter");
        demoProduct.setId(1L);
        demoProduct.setCategory(listDemoCategory);
        Mockito.doReturn(demoProduct)
                .when(repository)
                .findProductByName("Butter");
        Product p = service.findProductByName("Butter");
        assertEquals(demoProduct, p);


    }

    @Test
    void findProductByNameDTOTest() {
        Category createCategory = new Category();
        createCategory.setName("Groсery");
        List<Category> listDemoCategory = new ArrayList<>();
        listDemoCategory.add(createCategory);

        Product createProduct = new Product();
        createProduct.setName("Butter");
        createProduct.setId(1L);
        createProduct.setCategory(listDemoCategory);

        Mockito.doReturn(createProduct)
                .when(repository)
                .findProductByName("Butter");

        ProductDTO testDto = service.findProductDTOByName("Butter");

        assertEquals(testDto.getName(), createProduct.getName());
        assertEquals(testDto.getId(), createProduct.getId());
        assertLinesMatch(testDto.getCategory(), createProduct.getCategory().stream().map(Category::getName).collect(Collectors.toList()));
    }

    @Test
    void findDescriptionByProductNameTest() {
        Category createCategory = new Category();
        createCategory.setName("Groсery");
        List<Category> listDemoCategory = new ArrayList<>();
        listDemoCategory.add(createCategory);

        Product createProduct = new Product();
        createProduct.setName("Butter");
        createProduct.setId(1L);
        createProduct.setCategory(listDemoCategory);

        Mockito.doReturn(createProduct)
                .when(repository)
                .findProductByName("Butter");

        ProductDescription testProductDescription = new ProductDescription();
        testProductDescription.setProduct(createProduct);
        testProductDescription.setDescription("Test product");
        testProductDescription.setId(1L);

        Mockito.doReturn(testProductDescription)
                .when(descriptionRepository)
                .findDistinctByProduct(createProduct);

        ProductDescriptionDTO testDto = service.findDescriptionByProductName("Butter");

        assertEquals(testDto.getProduct(), "Butter");
        assertEquals(testDto.getDescription(), "Test product");
    }

    @Test
    void findProductItemByProductNameTest() {
        Category demoCategory = new Category();
        demoCategory.setName("Groсery");
        List<Category> listDemoCategory = new ArrayList<>();
        listDemoCategory.add(demoCategory);
        Product testProduct = new Product();
        testProduct.setName("Butter");
        testProduct.setId(1L);
        testProduct.setCategory(listDemoCategory);

        ProductItem newProductItem = new ProductItem();
        newProductItem.setProduct(testProduct);
        newProductItem.setPrice(100.0);
        newProductItem.setQuantity(10);
        newProductItem.setId(1L);

        Mockito.doReturn(testProduct)
                .when(repository)
                .findProductByName("Butter");

        Mockito.doReturn(newProductItem)
                .when(productItemRepository)
                .findProductItemByProduct(testProduct);

        ProductItemDTO testDto = service.findProductItemDtoByProductName("Butter");

        assertEquals(testDto.getProduct(), testProduct.getName());
        assertEquals(testDto.getPrice(), 100);
        assertEquals(testDto.getQuantity(), 10);
        assertEquals(testDto.getId(), 1L);

    }

    @Test
    void findAllInformationByProductNameTest() {
        Category createCategory = new Category();
        createCategory.setName("Groсery");
        List<Category> listDemoCategory = new ArrayList<>();
        listDemoCategory.add(createCategory);
        Product createProduct = new Product();
        createProduct.setName("Butter");
        createProduct.setId(1L);
        createProduct.setCategory(listDemoCategory);

        ProductDescription createProductDescription = new ProductDescription();
        createProductDescription.setProduct(createProduct);
        createProductDescription.setDescription("Test product");
        createProductDescription.setId(1L);

        ProductItem createProductItem = new ProductItem();
        createProductItem.setProduct(createProduct);
        createProductItem.setPrice(100.0);
        createProductItem.setQuantity(10);
        createProductItem.setId(1L);

        Mockito.doReturn(createProduct)
                .when(repository)
                .findProductByName("Butter");


        Mockito.doReturn(createProductDescription)
                .when(descriptionRepository)
                .findDistinctByProduct(createProduct);

        Mockito.doReturn(createProductItem)
                .when(productItemRepository)
                .findProductItemByProduct(createProduct);

        ProductTotalInformationDTO testDto = service.findAllInformationByProductName("Butter");

        assertEquals(testDto.getName(), "Butter");
        assertEquals(testDto.getCategory().size(), 1);
        assertEquals(testDto.getPrice(), 100.0);
        assertEquals(testDto.getQuantity(), 10);
        assertEquals(testDto.getDescription(), "Test product");

    }

    @Test
    void findALLProductsByCategoryNameTest() {
        Category newCategory = new Category();
        newCategory.setName("Groсery");
        List<Category> listDemoCategory = new ArrayList<>();
        listDemoCategory.add(newCategory);

        Product newProduct = new Product();
        newProduct.setName("Butter");
        newProduct.setId(1L);
        newProduct.setCategory(listDemoCategory);
        List<Product> newListProduct = new ArrayList<>();
        newListProduct.add(newProduct);
        newCategory.setProductList(newListProduct);

        Mockito.doReturn(newCategory)
                .when(categoryRepository)
                .findByName("Groсery");

        CategoryDTO testDto = service.findALLProductsByCategoryName("Groсery");

        assertEquals(testDto.getName(), "Groсery");
        assertEquals(testDto.getProductList().size(), 1);
        assertLinesMatch(testDto.getProductList(), newListProduct.stream().map(Product::getName).collect(Collectors.toList()));
    }

    @Test
    void findProductByID() {
        Category newCategory = new Category();
        newCategory.setName("Groсery");
        List<Category> listDemoCategory = new ArrayList<>();
        listDemoCategory.add(newCategory);

        Product newProduct = new Product();
        newProduct.setName("Butter");
        newProduct.setId(1L);
        newProduct.setCategory(listDemoCategory);

        Mockito.doReturn(Optional.of(newProduct))
                .when(repository)
                .findById(1L);

        ProductDTO testDto = service.findProductByID(1L);

        assertEquals(testDto.getName(), "Butter");
        assertEquals(testDto.getCategory().size(), 1);
    }

    @Test
    void findProductsByIDSTest() {
        Category newCategory = new Category();
        newCategory.setName("Groсery");
        List<Category> listDemoCategory = new ArrayList<>();
        listDemoCategory.add(newCategory);

        List<Product> result = new ArrayList<>();

        Product newProduct = new Product();
        newProduct.setName("Butter");
        newProduct.setId(1L);
        newProduct.setCategory(listDemoCategory);
        Product newProduct2 = new Product();
        newProduct2.setName("Flour");
        newProduct2.setId(2L);
        newProduct2.setCategory(listDemoCategory);

        result.add(newProduct);
        result.add(newProduct2);

        TwoProductIdsDto dto = new TwoProductIdsDto(1L, 2L);
        Mockito.doReturn(result)
                .when(repository)
                .findAllByIdBetween(dto.getFirstId(), dto.getSecondId());

        List<ProductDTO> testDto = service.findProductsByIDS(dto);

        assertEquals(testDto.size(),2);
        assertEquals(testDto.get(0).getName(),"Butter");
        assertEquals(testDto.get(1).getName(),"Flour");
    }
}