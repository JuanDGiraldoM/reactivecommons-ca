package co.com.bancolombia.model.whois.gateways;

import co.com.bancolombia.model.whois.WhoIs;
import reactor.core.publisher.Mono;

public interface WhoIsGateway {

    Mono<Void> emitWhoIs(WhoIs whoIs);
}
