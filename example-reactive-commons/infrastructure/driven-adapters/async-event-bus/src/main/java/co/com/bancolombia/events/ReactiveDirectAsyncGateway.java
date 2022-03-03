package co.com.bancolombia.events;

import co.com.bancolombia.model.message.Message;
import co.com.bancolombia.model.message.gateways.MessageRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.reactivecommons.api.domain.Command;
import org.reactivecommons.async.api.AsyncQuery;
import org.reactivecommons.async.api.DirectAsyncGateway;
import org.reactivecommons.async.impl.config.annotations.EnableDirectAsyncGateway;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.logging.Level;

@Log
@AllArgsConstructor
@EnableDirectAsyncGateway
public class ReactiveDirectAsyncGateway implements MessageRepository {
    public static final String TARGET_NAME = "consumer";// refers to remote spring.application.name property
    public static final String SEND_MESSAGE = "send.message";
    public static final String SEND_QUERY = "send.query";

    private final DirectAsyncGateway gateway;


    @Override
    public Mono<Void> sendMessage(Message message) {
        log.log(Level.INFO, "Sending command: {0}: {1}", new String[]{SEND_MESSAGE, message.toString()});
        return gateway.sendCommand(new Command<>(SEND_MESSAGE, UUID.randomUUID().toString(), message),
                TARGET_NAME);
    }

    @Override
    public Mono<Object> sendMessageQuery(String message2) {
        log.log(Level.INFO, "Sending query request: {0}: {1}", new String[]{SEND_QUERY, message2.toString()});
        return gateway.requestReply(new AsyncQuery<>(SEND_QUERY, message2), TARGET_NAME, Object.class/*change for proper model*/);
    }
}
