package co.com.bancolombia.model.savewho;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class SaveWho {
    public static final String NAME = "system.save.who";
    private String who;
    private String appName;
}
