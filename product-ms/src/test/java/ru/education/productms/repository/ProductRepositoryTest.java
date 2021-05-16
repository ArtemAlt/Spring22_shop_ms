package ru.education.productms.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import ru.education.productms.models.Entity.Category;
import ru.education.productms.models.Entity.Product;
import ru.education.productms.models.Entity.ProductDescription;
import ru.education.productms.models.Entity.ProductItem;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class ProductRepositoryTest {
    @Autowired
    ProductRepository repository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductDescriptionRepository descriptionRepository;
    @Autowired
    ProductItemRepository itemRepository;

    @Test
    void findProductByName() {
       Product testProduct =  repository.findProductByName("Beef");
       assertEquals(testProduct.getName(),"Beef");
       assertEquals(testProduct.getId(),3L);
    }

    @Test
    void findCategoryByNameTest() {
        Category testCategory = categoryRepository.findByName("NEW");
        assertEquals(testCategory.getName(),"NEW");
    }
    @Test
    void findDistinctByProductTest(){
        Product newProduct =  repository.findProductByName("Beef");
        ProductDescription testDescription = descriptionRepository.findDistinctByProduct(newProduct);
        assertEquals(testDescription.getDescription(),"NO DESCRIPTION");
    }
    @Test
    void findProductItemByProductTest(){
        Product newProduct =  repository.findProductByName("Beef");
        ProductItem testItem = itemRepository.findProductItemByProduct(newProduct);
        assertEquals(testItem.getProductName(),"Beef");
    }



}