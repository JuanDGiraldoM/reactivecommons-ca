package co.com.bancolombia.usecase.whois;

import co.com.bancolombia.model.constants.Constants;
import co.com.bancolombia.model.whois.WhoIs;
import co.com.bancolombia.model.whois.gateways.WhoIsGateway;
import co.com.bancolombia.model.whois.gateways.WhoIsRouter;
import co.com.bancolombia.usecase.savewho.SaveWhoUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class WhoIsUseCase {

    private final Constants constants;
    private final WhoIsGateway gateway;
    private final WhoIsRouter router;
    private final SaveWhoUseCase saveWhoUseCase;

    public Mono<Void> emitWhoIs(WhoIs whoIs) {
        return gateway.emitWhoIs(whoIs);
    }

    public Mono<Void> discover(String target) {
        var whoIsObject = WhoIs.builder()
                .who(target)
                .replyTo(constants.getAppName())
                .build();

        return emitWhoIs(whoIsObject)
                .then(router.register(target)
                        .flatMap(saveWhoUseCase::saveWho));
    }
}
