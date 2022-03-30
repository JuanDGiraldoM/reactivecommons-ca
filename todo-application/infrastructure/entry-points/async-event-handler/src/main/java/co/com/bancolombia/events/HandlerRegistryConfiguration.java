package co.com.bancolombia.events;

import co.com.bancolombia.events.handlers.CommandsHandler;
import co.com.bancolombia.events.handlers.EventsHandler;
import co.com.bancolombia.events.handlers.QueriesHandler;
import co.com.bancolombia.model.querytask.QueryTask;
import co.com.bancolombia.model.savetask.SaveTask;
import co.com.bancolombia.model.savewho.SaveWho;
import co.com.bancolombia.model.whois.WhoIs;
import org.reactivecommons.async.api.HandlerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HandlerRegistryConfiguration {

    @Bean
    public HandlerRegistry handlerRegistry(CommandsHandler commands, EventsHandler events, QueriesHandler queries) {
        return HandlerRegistry.register()
                .listenEvent(WhoIs.NAME, events::listenWhoIs, WhoIs.class)
                .handleCommand(SaveWho.NAME, commands::handleSaveWho, SaveWho.class)
                .handleCommand(SaveTask.NAME, commands::handleSaveTask, SaveTask.class)
                .serveQuery(QueryTask.NAME, queries::queryTask, QueryTask.class);
    }
}
