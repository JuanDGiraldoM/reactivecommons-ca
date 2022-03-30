package co.com.bancolombia.usecase.task;

import co.com.bancolombia.model.constants.Constants;
import co.com.bancolombia.model.task.gateways.TaskRepository;
import co.com.bancolombia.model.task.gateways.TaskRoutingTable;
import co.com.bancolombia.model.tasklist.TaskList;
import co.com.bancolombia.usecase.querytask.QueryTaskUseCase;
import co.com.bancolombia.usecase.whois.WhoIsUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class TaskUseCase {

    private final Constants constants;

    private final TaskRepository repository;
    private final TaskRoutingTable routingTable;

    private final QueryTaskUseCase queryTaskUseCase;
    private final WhoIsUseCase whoIsUseCase;

    public Mono<TaskList> getTaskList(String target) {
        if (target.equals(constants.getNameWho()))
            return repository.getTaskList();
        return getRemoteTaskList(target);
    }

    private Mono<TaskList> getRemoteTaskList(String target) {
        if (routingTable.containsKey(target))
            return queryTaskUseCase.getRemoteTasks(routingTable.getRouteName(target));

        return whoIsUseCase.discover(target)
                .flatMap(queryTaskUseCase::getRemoteTasks);
    }

}
