package co.com.bancolombia.model.events.gateways;

import co.com.bancolombia.model.transactionlog.TransactionLog;
import reactor.core.publisher.Mono;

public interface EventsGateway {
    Mono<Void> emit(TransactionLog transactionLog);
}
