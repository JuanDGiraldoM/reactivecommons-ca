package co.com.bancolombia.model.querytask.gateways;

import co.com.bancolombia.model.querytask.QueryTask;
import co.com.bancolombia.model.tasklist.TaskList;
import reactor.core.publisher.Mono;

public interface QueryTaskGateway {

    Mono<TaskList> getRemoteTasks(QueryTask queryTasks, String target);
}
