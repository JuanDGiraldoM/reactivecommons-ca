package co.com.bancolombia.model.savetask;

import co.com.bancolombia.model.task.Task;
import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
public class SaveTask extends Task {
    public static final String NAME = "tasks.save";

    public SaveTask() {
    }

    public SaveTask(String name, String description, String supervisor) {
        super(name, description, supervisor);
    }
}
