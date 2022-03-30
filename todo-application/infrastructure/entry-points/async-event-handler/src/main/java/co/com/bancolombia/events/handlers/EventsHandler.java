package co.com.bancolombia.events.handlers;

import co.com.bancolombia.model.whois.WhoIs;
import co.com.bancolombia.usecase.savewho.SaveWhoUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.async.impl.config.annotations.EnableEventListeners;
import reactor.core.publisher.Mono;

@Log
@AllArgsConstructor
@EnableEventListeners
public class EventsHandler {

    private final SaveWhoUseCase saveWhoUseCase;

    public Mono<Void> listenWhoIs(DomainEvent<WhoIs> event) {
        var whoIs = event.getData();
        log.info(whoIs.getReplyTo() + " is asking for " + whoIs.getWho());
        return saveWhoUseCase.saveWho(event.getData());
    }
}
