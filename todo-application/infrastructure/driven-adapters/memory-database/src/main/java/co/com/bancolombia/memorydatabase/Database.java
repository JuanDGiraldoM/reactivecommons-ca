package co.com.bancolombia.memorydatabase;

import co.com.bancolombia.model.task.Task;
import co.com.bancolombia.model.task.gateways.TaskRepository;
import co.com.bancolombia.model.tasklist.TaskList;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Log
@Repository
@NoArgsConstructor
public class Database implements TaskRepository {
    private static final List<Task> taskList = new CopyOnWriteArrayList<>();

    @Override
    public Mono<Void> saveTask(Task task) {
        return Mono.just(taskList.add(task))
                .doOnSuccess(s -> log.info("Task '" + task.getName() + "' saved!"))
                .then(Mono.empty());
    }

    @Override
    public Mono<TaskList> getTaskList() {
        return Mono.just(TaskList.builder().taskList(taskList).build());
    }
}
