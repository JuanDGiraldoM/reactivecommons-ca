package co.com.bancolombia.model.querytask;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class QueryTask {
    public static final String NAME = "tasks.getAll";
    private String personName;
    private String requester;
}
