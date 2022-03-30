package co.com.bancolombia.usecase.savewho;

import co.com.bancolombia.model.constants.Constants;
import co.com.bancolombia.model.savewho.SaveWho;
import co.com.bancolombia.model.savewho.gateways.SaveWhoGateway;
import co.com.bancolombia.model.task.gateways.TaskRoutingTable;
import co.com.bancolombia.model.whois.WhoIs;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SaveWhoUseCase {

    private final Constants constants;
    private final SaveWhoGateway gateway;
    private final TaskRoutingTable routingTable;

    public Mono<Void> saveWho(WhoIs whoIs) {
        if (constants.getNameWho().equals(whoIs.getWho()))
            return saveWho(whoIs.getReplyTo());
        return Mono.empty();
    }

    public Mono<Void> saveWho(String target) {
        SaveWho saveWho = SaveWho.builder()
                .who(constants.getNameWho())
                .appName(constants.getAppName())
                .build();

        return gateway.saveWho(saveWho, target);
    }

    public Mono<Void> saveWho(SaveWho saveWho) {
        return routingTable.registerRoute(saveWho);
    }
}
