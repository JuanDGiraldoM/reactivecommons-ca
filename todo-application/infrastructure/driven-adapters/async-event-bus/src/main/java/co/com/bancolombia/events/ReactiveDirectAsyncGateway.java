package co.com.bancolombia.events;

import co.com.bancolombia.model.querytask.QueryTask;
import co.com.bancolombia.model.querytask.gateways.QueryTaskGateway;
import co.com.bancolombia.model.savetask.SaveTask;
import co.com.bancolombia.model.savetask.gateways.SaveTaskGateway;
import co.com.bancolombia.model.savewho.SaveWho;
import co.com.bancolombia.model.savewho.gateways.SaveWhoGateway;
import co.com.bancolombia.model.task.Task;
import co.com.bancolombia.model.tasklist.TaskList;
import lombok.AllArgsConstructor;
import org.reactivecommons.api.domain.Command;
import org.reactivecommons.async.api.AsyncQuery;
import org.reactivecommons.async.api.DirectAsyncGateway;
import org.reactivecommons.async.impl.config.annotations.EnableDirectAsyncGateway;
import reactor.core.publisher.Mono;

import java.util.UUID;

@AllArgsConstructor
@EnableDirectAsyncGateway
public class ReactiveDirectAsyncGateway implements SaveWhoGateway, QueryTaskGateway, SaveTaskGateway {

    private final DirectAsyncGateway gateway;

    @Override
    public Mono<TaskList> getRemoteTasks(QueryTask queryTasks, String target) {
        var asyncQuery = new AsyncQuery<>(QueryTask.NAME, queryTasks);
        return gateway.requestReply(asyncQuery, target, TaskList.class);
    }

    @Override
    public Mono<Void> saveWho(SaveWho saveWho, String target) {
        var command = new Command<>(SaveWho.NAME, UUID.randomUUID().toString(), saveWho);
        return gateway.sendCommand(command, target);
    }

    @Override
    public Mono<Void> saveTask(Task task, String target) {
        var command = new Command<>(SaveTask.NAME, UUID.randomUUID().toString(), task);
        return gateway.sendCommand(command, target);
    }
}
