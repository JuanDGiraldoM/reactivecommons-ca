package co.com.bancolombia.usecase.savetask;

import co.com.bancolombia.model.constants.Constants;
import co.com.bancolombia.model.savetask.gateways.SaveTaskGateway;
import co.com.bancolombia.model.task.Task;
import co.com.bancolombia.model.task.gateways.TaskRepository;
import co.com.bancolombia.model.task.gateways.TaskRoutingTable;
import co.com.bancolombia.usecase.whois.WhoIsUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SaveTaskUseCase {

    private final Constants constants;
    private final TaskRepository repository;
    private final TaskRoutingTable routingTable;
    private final SaveTaskGateway gateway;

    private final WhoIsUseCase whoIsUseCase;

    public Mono<Void> saveTask(Task task, String target) {
        if (target.equals(constants.getNameWho()))
            return saveLocalTask(task);
        return saveRemoteTask(task, target);
    }

    public Mono<Void> saveLocalTask(Task task){
        return repository.saveTask(task);
    }

    private Mono<Void> saveRemoteTask(Task task, String target) {
        if (routingTable.containsKey(target))
            return gateway.saveTask(task, routingTable.getRouteName(target));

        return whoIsUseCase.discover(target)
                .then(saveRemoteTask(task, target));
    }
}
