package practice;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class MonoFluxGeneratorService {

    public Flux<String> fluxOfNames() {
        return Flux.fromIterable(List.of("Santosh", "Chandra", "Durga", "Udaya"))
                .log();
    }

    public Mono<String> monoName() {
        return Mono.just("SANTOSH")
                .log();
    }

    public Flux<String> fluxOfNamesWithMap() {
        return Flux.fromIterable(List.of("Santosh", "Chandra", "Durga"))
                .map(String::toUpperCase)
                //.map(o -> o.toUpperCase())
                .log();
    }

    public static void main(String[] args) {
        System.out.println("====START=====");
        MonoFluxGeneratorService obj = new MonoFluxGeneratorService();

        obj.fluxOfNames()
                .subscribe(name -> System.out.println("Name: " + name));
        System.out.println("====END=====");

        obj.monoName().subscribe(
                o -> System.out.println("Mono name is: " + o)
        );
    }
}
