package co.com.bancolombia.events;

import co.com.bancolombia.model.savewho.SaveWho;
import co.com.bancolombia.model.whois.gateways.WhoIsRouter;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.util.concurrent.ConcurrentHashMap;

@AllArgsConstructor
public class ReactiveReplyRouter implements WhoIsRouter {

    private final ConcurrentHashMap<String, Sinks.One<SaveWho>> processors = new ConcurrentHashMap<>();

    public Mono<SaveWho> register(String correlationID) {
        final Sinks.One<SaveWho> processor = Sinks.one();
        processors.put(correlationID, processor);
        return processor.asMono();
    }

    public void routeReply(String correlationID, SaveWho data) {
        final Sinks.One<SaveWho> processor = processors.remove(correlationID);
        if (processor != null)
            processor.tryEmitValue(data);
    }
}
