package ru.education.customerms.repository;

import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.data.repository.CrudRepository;
import ru.education.customerms.models.entity.ShopToken;

public interface ShopTokenRepository extends KeyValueRepository<ShopToken,Long> {
    ShopToken findShopTokenByValue(String value);

}
