package demo.annotation.repository;

import demo.annotation.model.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ReactiveCustomerRepository  extends ReactiveCrudRepository<Customer, String> {

    Flux<Customer> findByAge(int age);

    Flux<Customer> findByName(String name);
}
