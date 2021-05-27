package ru.education.productms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.education.productms.models.Entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findProductByName(String name);
    List<Product> findAllByIdBetween(Long first,Long second);
}
