package ru.education.customerms.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.education.core.model.dto.*;
import ru.education.customerms.models.entity.Customer;
import ru.education.customerms.service.CustomerService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService service;
//    private final ITokenService tokenService;
//    private final InvalidTokenService invalidTokenService;

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
//        invalidTokenService.addInvalidToken(request.getToken());
//todo - записать в хранилище
        return "Logout";
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequestDto request) {
        Customer customer = service.findByLoginAndPassword(request.getLogin(), request.getPassword());
        CustomerInfo customerInfo = CustomerInfo.builder()
                .userId(customer.getId())
                .name(customer.getName())
                .status(customer.getStatus().getType())
                .role(customer.getRole().get(0).getName())
                .build();
//        String token = tokenService.generateToken(customerInfo);
        return "new AuthResponseDto(token)";
    }

    @GetMapping("/check")
//    @PreAuthorize("hasRole('ROLE_USER')")
    public String check() {
        return "OK!";
    }


}
