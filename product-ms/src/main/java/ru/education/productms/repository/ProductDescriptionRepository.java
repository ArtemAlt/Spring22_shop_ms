package ru.education.productms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.education.productms.models.Entity.Product;
import ru.education.productms.models.Entity.ProductDescription;

public interface ProductDescriptionRepository extends JpaRepository<ProductDescription,Long> {
  ProductDescription findDistinctByProduct(Product product);
}
