package com.boyanscode.viewer;

import com.boyanscode.model.Customer;
import com.boyanscode.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerViewer {
    // @Autowired is not recommend, cause dependencies cannot be guaranteed
    private final CustomerRepository customerRepository;
    public CustomerViewer(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    record NewCustomerRequest(String name, String email, Integer age) {};
    @PostMapping
    private void addCustomer(@RequestBody NewCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.name);
        customer.setEmail(request.email);
        customer.setAge(request.age);
        customerRepository.save(customer);
    }

    @DeleteMapping("{customerId}")
    private void deleteCustomer(@PathVariable("customerId") Integer id) {
        customerRepository.deleteById(id);
    }

    @PostMapping("{customerId}")
    private void updateCustomer(
            @PathVariable("customerId") Integer id,
            @RequestBody NewCustomerRequest request) {

        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(request.name);
        customer.setEmail(request.email);
        customer.setAge(request.age);
        customerRepository.save(customer);
    }
}
