package practice;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class MonoFluxTransformTest {

    MonoFluxTransform objUnderTest = new MonoFluxTransform();
    @Test
    public void testFluxOfNamesWithMap() {
        Flux<String> stringFluxOutput = objUnderTest.fluxOfNamesWithMap();

        StepVerifier.create(stringFluxOutput)
                .expectNext("SANTOSH")
                .expectNextCount(2)
                .verifyComplete();
    }
}
