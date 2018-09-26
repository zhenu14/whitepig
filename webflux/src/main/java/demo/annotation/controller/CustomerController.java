package demo.annotation.controller;
import demo.annotation.model.Customer;
import demo.annotation.repository.ReactiveCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.Duration;

@RestController
@RequestMapping(value = "/api")
public class CustomerController {

    @Autowired
    ReactiveCustomerRepository customerRepository;

    @GetMapping("/customers")
    public Flux<Customer> getAllCustomers() {
        System.out.println("Get all Customers...");
        return customerRepository.findAll();
    }

    @PostMapping("/customers/create")
    public Mono<Customer> createCustomer(@Valid @RequestBody Customer customer) {
        System.out.println("Create Customer: " + customer.getName() + "...");

        customer.setActive(false);
        return customerRepository.save(customer);
    }

    @PutMapping("/customers/{id}")
    public Mono<ResponseEntity<Customer>> updateCustomer(@PathVariable("id") String id,
                                                         @RequestBody Customer customer) {
        System.out.println("Update Customer with ID = " + id + "...");

        return customerRepository.findById(id)
                .flatMap(customerData -> {
                    customerData.setName(customer.getName());
                    customerData.setAge(customer.getAge());
                    customerData.setActive(customer.isActive());
                    return customerRepository.save(customerData);
                })
                .map(updatedcustomer -> new ResponseEntity<>(updatedcustomer, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") String id) {
        System.out.println("Delete Customer with ID = " + id + "...");

        try {
            customerRepository.deleteById(id).subscribe();
        } catch (Exception e) {
            return new ResponseEntity<>("Fail to delete!", HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
    }

    @DeleteMapping("/customers/delete")
    public ResponseEntity<String> deleteAllCustomers() {
        System.out.println("Delete All Customers...");

        try {
            customerRepository.deleteAll().subscribe();
        } catch (Exception e) {
            return new ResponseEntity<>("Fail to delete!", HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>("All customers have been deleted!", HttpStatus.OK);
    }

    @GetMapping("/customers/findbyname")
    public Flux<Customer> findByName(@RequestParam String name) {

        return customerRepository.findByName(name).delayElements(Duration.ofMillis(1000));
    }
}
