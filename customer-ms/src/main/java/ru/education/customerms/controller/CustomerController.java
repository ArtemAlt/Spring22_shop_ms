package ru.education.customerms.controller;


import interfaces.ITokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.education.core.model.UserInfo;
import ru.education.core.model.dto.*;
import ru.education.customerms.models.entity.Customer;
import ru.education.customerms.models.entity.ShopRole;
import ru.education.customerms.service.CustomerService;
import ru.education.customerms.service.RedisService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService service;
    private final ITokenService tokenService;
    private final RedisService invalidTokenService;

    @PostMapping("/signup")
    public String signUp(@RequestBody SignUpRequestDto signUpRequest) {
        Customer customer = new Customer();
        customer.setPassword(signUpRequest.getPassword());
        customer.setName(signUpRequest.getLogin());

        service.save(customer);
        return "OK";
    }

    @PostMapping("/logout")
    public String logOut(@RequestBody CustomerLogoutDto request) {
    invalidTokenService.addInvalidToken(request.getToken());
    return "Logout";
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequestDto request) {
        Customer customer = service.findByLoginAndPassword(request.getLogin(), request.getPassword());
        List<String> roles = customer.getShopRole().stream().map(ShopRole::getName).collect(Collectors.toList());
        UserInfo userInfo = UserInfo.builder()
                .userId(customer.getId())
                .role(roles)
                .build();
        return tokenService.generateToken(userInfo);
    }

    @GetMapping("/check")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String check() {
        return "OK!";
    }


}
