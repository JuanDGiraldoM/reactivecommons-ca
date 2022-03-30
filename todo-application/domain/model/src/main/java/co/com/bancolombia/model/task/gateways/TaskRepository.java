package co.com.bancolombia.model.task.gateways;

import co.com.bancolombia.model.task.Task;
import co.com.bancolombia.model.tasklist.TaskList;
import reactor.core.publisher.Mono;

public interface TaskRepository {

    Mono<Void> saveTask(Task task);

    Mono<TaskList> getTaskList();
}
