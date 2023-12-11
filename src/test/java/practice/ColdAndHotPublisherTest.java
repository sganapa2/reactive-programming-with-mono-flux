package practice;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

import java.time.Duration;

import static reactor.core.publisher.Mono.delay;

public class ColdAndHotPublisherTest {

    @Test
    public void testColdStreamReturnsSameData() {
        var testFlux = Flux.range(1, 8);

        testFlux.subscribe(o ->
        System.out.println("subscriber-1 data=" + o));

        System.out.println("Now same flux is subscribed second time, same data returned");
        testFlux.subscribe(o ->
                System.out.println("subscriber-2 data=" + o));

    }

    @Test
    public void testHotStreamReturnsContinuedData() {
        var testFlux = Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1));

        ConnectableFlux<Integer> connectableFlux = testFlux.publish();
        connectableFlux.connect();

        //subscriber 1
        connectableFlux.subscribe(i ->
                System.out.println("subscriber-1 i=" + i));

        delay(Duration.ofSeconds(4000));

        System.out.println("Now second subscriber defined");
        //subscriber 2
        connectableFlux.subscribe(i ->
                System.out.println("subscriber-2 i=" + i));

        delay(Duration.ofMillis(10000));

    }
}
