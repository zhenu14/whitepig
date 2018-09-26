package demo.functional.router;

import demo.functional.model.Person;
import demo.functional.repository.PersonRepository;
import demo.functional.service.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * @author prayer
 */
@Configuration
public class PersonRouter {

    private final PersonRepository repository;

    private final PersonService service;

    public PersonRouter(PersonRepository repository, PersonService service) {
        this.repository = repository;
        this.service = service;
    }

    @Bean
    public RouterFunction<?> personRoutes() {
        return RouterFunctions
                .route(GET("/person/{id}").and(accept(APPLICATION_JSON)), request -> {
                    String personId = request.pathVariable("id");
                    Mono<ServerResponse> notFound = ServerResponse.notFound().build();
                    return repository.findById(personId)
                            .flatMap(person -> ServerResponse.ok().body(Mono.just(person), Person.class))
                            .switchIfEmpty(notFound);
                })
                .andRoute(GET("/person").and(accept(APPLICATION_JSON)), request ->
                        ServerResponse.ok().body(repository.findAll(), Person.class))
                .andRoute(POST("/person").and(contentType(APPLICATION_JSON)), request ->
                        ServerResponse.ok().body(service.addPerson(request.bodyToMono(Person.class)), Person.class))
                .andRoute(POST("/person/ip_info/update"), request -> {
                    service.updateIpInfo();
                    return ServerResponse.ok().build();
                });
    }
}
