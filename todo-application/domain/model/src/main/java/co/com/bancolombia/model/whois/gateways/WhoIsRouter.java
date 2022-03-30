package co.com.bancolombia.model.whois.gateways;

import co.com.bancolombia.model.savewho.SaveWho;
import reactor.core.publisher.Mono;

public interface WhoIsRouter {

    Mono<SaveWho> register(String correlationID);

    Mono<Void> routeReply(String correlationID, SaveWho data);
}
