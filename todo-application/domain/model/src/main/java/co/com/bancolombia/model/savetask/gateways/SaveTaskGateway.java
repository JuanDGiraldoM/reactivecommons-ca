package co.com.bancolombia.model.savetask.gateways;

import co.com.bancolombia.model.task.Task;
import reactor.core.publisher.Mono;

public interface SaveTaskGateway {

    Mono<Void> saveTask(Task task, String target);
}
