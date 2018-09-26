package demo.functional.service;

import com.mongodb.util.JSON;
import demo.functional.model.Person;
import demo.functional.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author prayer
 */
@Slf4j
@Service
public class PersonService {

    private final PersonRepository repository;

    private final IpService ipService;

    public PersonService(PersonRepository repository, IpService ipService) {
        this.repository = repository;
        this.ipService = ipService;
    }

    public Mono<Person> addPerson(Mono<Person> mono) {
        return mono.flatMap(this::addIpInfo)
                .flatMap(repository::save);
    }

    private Mono<Person> addIpInfo(Person person) {
        return ipService.getIpInfo(person.getIp()).map(ipInfo -> person.copyWithIpInfo(JSON.parse(ipInfo)));
    }

    public void updateIpInfo() {
        LocalDateTime dateTime = LocalDateTime.now().minusDays(90);
        repository.findByUpdatedAtLessThan(dateTime)
                .buffer(300)
                .onBackpressureBuffer(5000)
                .parallel(2)
                .flatMap(this::updateIpInfo)
                .subscribe(
                        p -> log.info("Updated IP information for person with id {}", p.getId()),
                        t -> log.error("Failed IP information update stream", t)
                );
    }

    private Flux<Person> updateIpInfo(List<Person> batch) {
        return batch.stream()
                .map(this::addIpInfo)
                .map(monoP -> monoP.flux())
                .reduce(Flux.empty(), (p1, p2) -> p1.concatWith(p2))
                .flatMap(repository::save);
    }

}
