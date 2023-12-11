package practice;

import lombok.val;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class ConcatAndConcatWithOperatorsTest {

    ConcatAndConcatWithOperators objUnderTest = new ConcatAndConcatWithOperators();
    @Test
    public void testConcatOperator() {
        val concatedFluxResult = objUnderTest.concatExample();

        StepVerifier.create(concatedFluxResult)
                .expectNext("result1")
                .expectNext("result2")
                .expectNextCount(2)
                .verifyComplete();

        StepVerifier.create(concatedFluxResult)
                .expectNext("result1", "result2", "result3", "result4")
                .verifyComplete();
    }

    @Test
    public void testConcatWithOperatorMono() {
        val result = objUnderTest.concatWithMonoExample();

        StepVerifier.create(result)
                .expectNext("result3", "result1")
                .verifyComplete();
    }
}
