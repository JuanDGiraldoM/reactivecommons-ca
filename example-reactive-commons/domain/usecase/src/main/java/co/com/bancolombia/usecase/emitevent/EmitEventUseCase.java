package co.com.bancolombia.usecase.emitevent;

import co.com.bancolombia.model.events.gateways.EventsGateway;
import co.com.bancolombia.model.transactionlog.TransactionLog;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import reactor.core.publisher.Mono;

@Log
@RequiredArgsConstructor
public class EmitEventUseCase {

    private final EventsGateway eventsGateway;

    public Mono<Void> sendTransactionalLog(TransactionLog transactionLog){
        return Mono.defer(()-> eventsGateway.emit(transactionLog.toBuilder().build()));

    }
}
