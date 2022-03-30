package co.com.bancolombia.model.task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Task {
    public static final String NAME = "tasks.save";

    private String name;
    private String description;
    private String supervisor;
}
