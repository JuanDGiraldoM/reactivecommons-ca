package co.com.bancolombia.model.whois;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class WhoIs {
    public static final String NAME = "system.whois";
    private String who;
    private String replyTo;
}
