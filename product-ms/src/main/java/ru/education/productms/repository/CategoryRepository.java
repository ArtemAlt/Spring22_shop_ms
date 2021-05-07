package ru.education.productms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.education.productms.models.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(String name);

}
