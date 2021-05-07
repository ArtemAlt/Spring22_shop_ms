package ru.education.productms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.education.productms.models.Entity.Product;
import ru.education.productms.models.Entity.ProductItem;

public interface ProductItemRepository extends JpaRepository<ProductItem,Long> {

    ProductItem findProductItemByProduct(Product product);
}
