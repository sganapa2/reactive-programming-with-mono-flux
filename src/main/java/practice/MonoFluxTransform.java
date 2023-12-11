package practice;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Function;

public class MonoFluxTransform {

    public Flux<String> fluxOfNames() {
        return Flux.fromIterable(List.of("Santosh", "Chandra", "Durga", "Udaya"))
                .log();
    }

    public Mono<String> monoName() {
        return Mono.just("SANTOSH")
                .log();
    }

    Function<Flux<String>, Flux<String>> transformFunction = inputNames ->
            inputNames.map(String::toUpperCase)
                    .filter(o -> o.length() >= 3);
     public Flux<String> fluxOfNamesWithMap() {
        return Flux.fromIterable(List.of("Santosh", "Chandra", "Durga"))
                .transform(transformFunction)
                .log();
    }

    public static void main(String[] args) {
        System.out.println("====START=====");
        MonoFluxTransform obj = new MonoFluxTransform();

        obj.fluxOfNames()
                .subscribe(name -> System.out.println("Name: " + name));
        System.out.println("====END=====");

        obj.monoName().subscribe(
                o -> System.out.println("Mono name is: " + o)
        );
    }
}
