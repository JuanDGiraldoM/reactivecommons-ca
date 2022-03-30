package co.com.bancolombia.model.tasklist;

import co.com.bancolombia.model.task.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TaskList {
    private List<Task> taskList;
}
