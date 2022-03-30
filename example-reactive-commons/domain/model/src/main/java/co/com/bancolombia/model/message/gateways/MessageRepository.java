package co.com.bancolombia.model.message.gateways;

import co.com.bancolombia.model.message.Message;
import reactor.core.publisher.Mono;

public interface MessageRepository {

    Mono<Void> sendMessage(Message message);
    Mono<Object> sendMessageQuery(String message2);
}
