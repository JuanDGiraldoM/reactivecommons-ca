package co.com.bancolombia.events;

import co.com.bancolombia.events.handlers.CommandsHandler;
import co.com.bancolombia.events.handlers.EventsHandler;
import co.com.bancolombia.events.handlers.QueriesHandler;
import lombok.SneakyThrows;
import org.reactivecommons.async.api.HandlerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HandlerRegistryConfiguration {

    // see more at: https://reactivecommons.org/reactive-commons-java/#_handlerregistry_2
    @Bean
    public HandlerRegistry handlerRegistry(CommandsHandler commands, EventsHandler events, QueriesHandler queries) {
        return HandlerRegistry.register()
                //.listenNotificationEvent("some.broadcast.event.name", events::handleEventA, Object.class/*change for proper model*/)
                .listenEvent("log.created", events::handleEventA, Object.class/*change for proper model*/)
                .handleCommand("send.message", commands::handleCommandA, Object.class/*change for proper model*/)
                .serveQuery("send.query", queries::handleQueryA, Object.class/*change for proper model*/);
    }
}
