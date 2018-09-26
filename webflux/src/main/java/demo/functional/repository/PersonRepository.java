package demo.functional.repository;

import demo.functional.model.Person;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

/**
 * @author prayer
 */
public interface PersonRepository extends ReactiveCrudRepository<Person, String> {

    @Query
    Flux<Person> findByUpdatedAtLessThan(LocalDateTime updatedAt);

}
