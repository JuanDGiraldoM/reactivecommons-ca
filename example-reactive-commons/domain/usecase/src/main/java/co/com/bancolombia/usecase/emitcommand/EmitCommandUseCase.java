package co.com.bancolombia.usecase.emitcommand;

import co.com.bancolombia.model.message.Message;
import co.com.bancolombia.model.message.gateways.MessageRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class EmitCommandUseCase {

    private final MessageRepository messageRepository;

    public Mono<Void> sendMessageCommand(Message message){
        return Mono.defer(()-> messageRepository.sendMessage(message));
    }

}
