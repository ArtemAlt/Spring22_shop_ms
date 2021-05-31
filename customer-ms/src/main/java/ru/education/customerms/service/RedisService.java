package ru.education.customerms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.education.customerms.models.entity.ShopToken;
import ru.education.customerms.repository.ShopTokenRepository;

@Service
public class RedisService {
    @Autowired
    ShopTokenRepository repository;

    public boolean checkIsTokenInvalid(String value){
        return (repository.findShopTokenByValue(value)==null);
    }

    public void addInvalidToken(String token){
        ShopToken securityToken = new ShopToken();
        securityToken.setValue(token);
        repository.save(securityToken);
    }
}
