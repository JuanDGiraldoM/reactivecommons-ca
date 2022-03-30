package co.com.bancolombia.events.handlers;

import co.com.bancolombia.model.querytask.QueryTask;
import co.com.bancolombia.model.tasklist.TaskList;
import co.com.bancolombia.usecase.task.TaskUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.reactivecommons.async.impl.config.annotations.EnableQueryListeners;
import reactor.core.publisher.Mono;

@Log
@AllArgsConstructor
@EnableQueryListeners
public class QueriesHandler {

    private final TaskUseCase taskUseCase;

    public Mono<TaskList> queryTask(QueryTask queryTask) {
        log.info("Asking tasks to '" + queryTask.getRequester() + "'");
        return taskUseCase.getLocalTaskList();
    }
}
