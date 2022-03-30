package co.com.bancolombia.events.handlers;

import co.com.bancolombia.model.savetask.SaveTask;
import co.com.bancolombia.model.savewho.SaveWho;
import co.com.bancolombia.usecase.savetask.SaveTaskUseCase;
import co.com.bancolombia.usecase.savewho.SaveWhoUseCase;
import co.com.bancolombia.usecase.task.TaskUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.reactivecommons.api.domain.Command;
import org.reactivecommons.async.impl.config.annotations.EnableCommandListeners;
import reactor.core.publisher.Mono;

@Log
@AllArgsConstructor
@EnableCommandListeners
public class CommandsHandler {

    private final SaveTaskUseCase saveTaskUseCase;
    private final SaveWhoUseCase saveWhoUseCase;

    public Mono<Void> handleSaveWho(Command<SaveWho> command) {
        var saveWho = command.getData();
        log.info("Resolve " + saveWho.getWho() + " to " + saveWho.getAppName());
        return saveWhoUseCase.saveWho(saveWho);
    }

    public Mono<Void> handleSaveTask(Command<SaveTask> command) {
        var saveTask = command.getData();
        log.info("Saving task " + saveTask.getName());
        return saveTaskUseCase.saveLocalTask(saveTask);
    }
}
