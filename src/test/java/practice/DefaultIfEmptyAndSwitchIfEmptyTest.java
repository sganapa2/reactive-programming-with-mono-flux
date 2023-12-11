package practice;

import lombok.val;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class DefaultIfEmptyAndSwitchIfEmptyTest {

    DefaultIfEmptyAndSwitchIfEmpty objUnderTest = new DefaultIfEmptyAndSwitchIfEmpty();

    @Test
    public void testDefaultIfEmptyFluxData() {
        val fluxResult = objUnderTest.defaultIfEmptyScenario();

        StepVerifier.create(fluxResult)
                .expectNext("default string if flux data is empty")
                .verifyComplete();
    }

    @Test
    public void testSwitchIfEmptyScenario() {
        val fluxResult = objUnderTest.switchIfEmptyScenario();
        StepVerifier.create(fluxResult)
                .verifyComplete();
    }

}
