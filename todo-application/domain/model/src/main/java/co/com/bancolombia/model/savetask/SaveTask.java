package co.com.bancolombia.model.savetask;

import co.com.bancolombia.model.task.Task;
import lombok.Builder;

@Builder(toBuilder = true)
public class SaveTask extends Task {
    public static final String NAME = "tasks.save";
}
