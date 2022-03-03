package co.com.bancolombia.usecase.emitquery;

import co.com.bancolombia.model.message.Message;
import co.com.bancolombia.model.message.gateways.MessageRepository;
import co.com.bancolombia.model.transactionlog.TransactionLog;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class EmitQueryUseCase {

    private final MessageRepository messageRepository;

    public Mono<Object> sendMessageQuery(String message){
        return Mono.defer(()-> messageRepository.sendMessageQuery(message));

    }
}
