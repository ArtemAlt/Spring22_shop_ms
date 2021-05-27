package ru.education.customerms.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.education.core.model.dto.AddCustomerDTO;
import ru.education.customerms.models.entity.Customer;
import ru.education.customerms.models.entity.Role;
import ru.education.customerms.repository.CustomerRepository;
import ru.education.customerms.repository.RoleRepository;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    private final RoleRepository roleRepository;



    public Customer findCustomer(String customer) {
        return repository.findByName(customer);
    }

    public Customer saveCustomer(AddCustomerDTO dto)  {
        Customer customer = new Customer();
        Role role = null;
        try {
            role = roleRepository.findById(dto.getRole()).orElseThrow(()->new NoSuchFieldException("No such role - "+dto.getRole()));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        assert role != null;
        log.info("New customer role in -"+role.getName());
        customer.addRoleCustomer(role);
        log.info("New customer role out -"+customer.getRole().stream().map(Role::getName));
//        customer.setPassword(encoder.encode(dto.getPassword()));
        log.info("New customer pass - "+customer.getPassword());
        customer.setName(dto.getName());
        log.info("New customer name - "+customer.getName());
        return repository.saveAndFlush(customer);
    }

    public Customer save (Customer customer){
        Role role = roleRepository.findByName("ROLE_USER");  //todo - надо переделать на лист ролей
        customer.setRole((List<Role>) role);
//        customer.setPassword(encoder.encode(customer.getPassword()));
        return repository.save(customer);
    }
    public Customer findByLoginAndPassword(String login, String password){
        Customer c = repository.findByName(login);
        if (c != null ) {
//            if (encoder.matches(password,c.getPassword())){
//                return c;
//            }
        }
        return null;
    }
}
