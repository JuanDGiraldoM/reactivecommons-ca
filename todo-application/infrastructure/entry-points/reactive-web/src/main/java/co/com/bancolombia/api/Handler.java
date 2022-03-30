package co.com.bancolombia.api;

import co.com.bancolombia.model.constants.Constants;
import co.com.bancolombia.model.task.Task;
import co.com.bancolombia.model.tasklist.TaskList;
import co.com.bancolombia.usecase.savetask.SaveTaskUseCase;
import co.com.bancolombia.usecase.task.TaskUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Log
@Component
@RequiredArgsConstructor
public class Handler {
    private final Constants constants;
    private final TaskUseCase taskUseCase;
    private final SaveTaskUseCase saveTaskUseCase;

    public Mono<ServerResponse> listTasksHandler(ServerRequest serverRequest) {
        var name = serverRequest.queryParam("name").orElse(constants.getNameWho());
        log.info("Getting task list from '" + name + "'");
        return ServerResponse.ok().body(taskUseCase.getTaskList(name), TaskList.class);
    }

    public Mono<ServerResponse> saveTasksHandler(ServerRequest serverRequest) {
        var name = serverRequest.queryParam("name").orElse(constants.getNameWho());
        log.info("Saving task to '" + name + "'");
        return serverRequest.bodyToMono(Task.class)
                .flatMap(task -> ServerResponse.ok().body(saveTaskUseCase.saveTask(task, name), Void.class));
    }
}
