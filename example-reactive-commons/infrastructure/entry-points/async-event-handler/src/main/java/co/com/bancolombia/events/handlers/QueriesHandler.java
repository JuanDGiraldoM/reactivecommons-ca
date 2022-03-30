package co.com.bancolombia.events.handlers;

import lombok.AllArgsConstructor;
import org.reactivecommons.async.api.From;
import org.reactivecommons.async.impl.config.annotations.EnableQueryListeners;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@EnableQueryListeners
public class QueriesHandler {
//    private final SampleUseCase sampleUseCase;


    public Mono<Object/*change for proper model*/> handleQueryA(Object query /*change for proper model*/) {
        System.out.println("query received->" + query); // TODO: Remove this line
//        return sampleUseCase.doSomethingReturningNoMonoVoid(query);
        return Mono.just("Response Data");
    }
}
