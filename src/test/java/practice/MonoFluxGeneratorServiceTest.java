package practice;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class MonoFluxGeneratorServiceTest {

    MonoFluxGeneratorService serviceUnderTest = new MonoFluxGeneratorService();

    @Test
    public void testFluxOfNames() {
        var namesFlux = serviceUnderTest.fluxOfNames();

        StepVerifier.create(namesFlux)
                .expectNext("Santosh", "Chandra", "Durga", "Udaya")
                .verifyComplete();

        StepVerifier.create(namesFlux)
                .expectNextCount(4)
                .verifyComplete();

        StepVerifier.create(namesFlux)
                .expectNext("Santosh")
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    public void testFluxOfNamesWithMap() {
        var namesFlux = serviceUnderTest.fluxOfNamesWithMap();

        StepVerifier.create(namesFlux)
                .expectNext("SANTOSH", "CHANDRA", "DURGA")
                .verifyComplete();

        StepVerifier.create(namesFlux)
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    public void testMonoName() {
        var namesFlux = serviceUnderTest.monoName();

        StepVerifier.create(namesFlux)
                .expectNext("SANTOSH")
                .verifyComplete();

        StepVerifier.create(namesFlux)
                .expectNextCount(1)
                .verifyComplete();
    }

}
