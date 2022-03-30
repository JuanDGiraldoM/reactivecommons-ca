package co.com.bancolombia.usecase.querytask;

import co.com.bancolombia.model.querytask.QueryTask;
import co.com.bancolombia.model.querytask.gateways.QueryTaskGateway;
import co.com.bancolombia.model.tasklist.TaskList;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class QueryTaskUseCase {

    private final QueryTaskGateway gateway;

    public Mono<TaskList> getRemoteTasks(String target, String appName) {
        var queryTasks = QueryTask.builder()
                .personName(target)
                .requester(appName)
                .build();
        return gateway.getRemoteTasks(queryTasks, target);
    }
}
