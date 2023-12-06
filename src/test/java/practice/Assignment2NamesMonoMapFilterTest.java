package practice;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class Assignment2NamesMonoMapFilterTest {

    Assignment2NamesMonoMapFilter objUnderTest = new Assignment2NamesMonoMapFilter();

    @Test
    public void testNamesMonoMapFilter() {
        var monoOutput = objUnderTest.namesMonoMapFilter(2);

        StepVerifier.create(monoOutput)
                .expectNext("ALEX")
                .verifyComplete();

        StepVerifier.create(monoOutput)
                .expectNextCount(1)
                .verifyComplete();
    }
}
