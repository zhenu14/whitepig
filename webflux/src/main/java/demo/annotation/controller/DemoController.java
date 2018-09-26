package demo.annotation.controller;

import demo.annotation.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author prayer
 */
@RestController
@RequestMapping(value="/api/customer")
public class DemoController {

    Map<Long, Customer> custStores = new HashMap<>();

    @PostConstruct
    public void initIt() throws Exception {
        custStores.put(1L, new Customer(1, true, "Smith", 20));
        custStores.put(2L, new Customer(2, true, "Johnson", 25));
    }

    @GetMapping("/")
    public Flux<Customer> getAll() {
        return Flux.fromIterable(custStores.entrySet().stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public Mono<Customer> getCustomer(@PathVariable Long id) {
        return Mono.justOrEmpty(custStores.get(id));
    }

    @PostMapping("/post")
    public Mono<ResponseEntity<String>> postCustomer(@RequestBody Customer customer){
        // do post
        custStores.put(customer.getId(), customer);

        // log on console
        System.out.println("########### POST:" + customer);

        return Mono.just(new ResponseEntity<>("Post Successfully!", HttpStatus.CREATED));
    }

    @PutMapping("/put/{id}")
    public Mono<ResponseEntity<Customer>> putCustomer(@PathVariable Long id, @RequestBody Customer customer){
        // reset customer.Id
        customer.setId(id);

        custStores.put(id, customer);

        // log on console
        System.out.println("########### PUT:" + customer);

        return Mono.just(new ResponseEntity<>(customer, HttpStatus.CREATED));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<String>> deleteMethod(@PathVariable Long id) {
        // delete processing
        custStores.remove(id);
        return Mono.just(new ResponseEntity<>("Delete Succesfully!", HttpStatus.ACCEPTED));
    }

}
