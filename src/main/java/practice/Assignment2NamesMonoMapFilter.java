package practice;

import lombok.val;
import reactor.core.publisher.Mono;

public class Assignment2NamesMonoMapFilter {
    public Mono<String> namesMonoMapFilter(int strLength) {
        return Mono.just("alex")
                .map(String::toUpperCase)
                .filter(s -> s.length() > strLength)
                .log();
    }

    public static void main(String[] args) {
        Assignment2NamesMonoMapFilter obj = new Assignment2NamesMonoMapFilter();
        System.out.println("output: " + obj.namesMonoMapFilter(3).subscribe(System.out::println));
    }
}
