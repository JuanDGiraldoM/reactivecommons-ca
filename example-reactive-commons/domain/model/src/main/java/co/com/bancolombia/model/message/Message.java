package co.com.bancolombia.model.message;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Message {

    String name;
    String description;
}
