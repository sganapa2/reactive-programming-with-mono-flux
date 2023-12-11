package practice;

import reactor.core.publisher.Flux;

import java.util.List;
import java.util.function.Function;

public class DefaultIfEmptyAndSwitchIfEmpty {

    List<String> namesList = List.of("Santosh", "Ojas", "Tejas");
    public Flux<String> defaultIfEmptyScenario() {
        var fluxResult = Flux.fromIterable(namesList)
                .filter(o -> o.length() > 10)
                .defaultIfEmpty("default string if flux data is empty")
                .log();
        return fluxResult;
    }

    public Flux<String> switchIfEmptyScenario() {
        var fluxResult = Flux.fromIterable(namesList)
                .filter(o -> o.length() > 10)
                .switchIfEmpty(fluxOfNamesWithMap())
                //.defaultIfEmpty("default string if flux data is empty")
                .log();
        return fluxResult;
    }
    Function<Flux<String>, Flux<String>> transformFunction = inputNames ->
            inputNames.map(String::toUpperCase)
                    .filter(o -> o.length() >= 10);
    public Flux<String> fluxOfNamesWithMap() {
        return Flux.fromIterable(List.of("Santosh", "Chandra", "Durga"))
                .transform(transformFunction)
                .log();
    }
}
