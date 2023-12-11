package practice;

import lombok.val;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ConcatAndConcatWithOperators {

    public Flux<String> concatExample() {
        val flux1 = Flux.just("result1", "result2");
        val flux2 = Flux.just("result3", "result4");
        return Flux.concat(flux1, flux2).log();
    }

    public Flux<String> concatWithMonoExample() {
        val monoResult1 = Mono.just("result1");
        val monoResult2 = Mono.just("result3");
        return monoResult2.concatWith(monoResult1).log();
    }

}
