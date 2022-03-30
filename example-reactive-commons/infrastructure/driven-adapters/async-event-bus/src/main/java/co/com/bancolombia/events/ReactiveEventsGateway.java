package co.com.bancolombia.events;

import co.com.bancolombia.model.events.gateways.EventsGateway;
import co.com.bancolombia.model.transactionlog.TransactionLog;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.api.domain.DomainEventBus;
import org.reactivecommons.async.impl.config.annotations.EnableDomainEventBus;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.logging.Level;

import static reactor.core.publisher.Mono.from;

@Log
@RequiredArgsConstructor
@EnableDomainEventBus
public class ReactiveEventsGateway implements EventsGateway {
    public static final String EVENT_NAME = "log.created";
    private final DomainEventBus domainEventBus;


    @Override
    public Mono<Void> emit(TransactionLog transactionLog) {
        log.log(Level.INFO, "Sending domain event:::::::::: {0}: {1}", new String[]{EVENT_NAME, transactionLog.toString()});
        return from(domainEventBus.emit(new DomainEvent<>(EVENT_NAME, UUID.randomUUID().toString(), transactionLog)));
    }
}
