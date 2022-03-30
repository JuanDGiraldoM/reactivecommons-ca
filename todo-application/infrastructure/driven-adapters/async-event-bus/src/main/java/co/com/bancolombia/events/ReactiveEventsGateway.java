package co.com.bancolombia.events;

import co.com.bancolombia.model.whois.WhoIs;
import co.com.bancolombia.model.whois.gateways.WhoIsGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.api.domain.DomainEventBus;
import org.reactivecommons.async.impl.config.annotations.EnableDomainEventBus;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Log
@RequiredArgsConstructor
@EnableDomainEventBus
public class ReactiveEventsGateway implements WhoIsGateway {

    private final DomainEventBus domainEventBus;

    @Override
    public Mono<Void> emitWhoIs(WhoIs whoIs) {
        var event = new DomainEvent<>(WhoIs.NAME, UUID.randomUUID().toString(), whoIs);
        log.info("I'm asking for '" + whoIs.getWho() + "'");
        return Mono.from(domainEventBus.emit(event))
                .then(Mono.empty());
    }
}
