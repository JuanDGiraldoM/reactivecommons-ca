package co.com.bancolombia.model.constants;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Constants {

    private String appName;
    private String nameWho;
}
