package co.com.bancolombia.model.savewho.gateways;

import co.com.bancolombia.model.savewho.SaveWho;
import reactor.core.publisher.Mono;

public interface SaveWhoGateway {

    Mono<Void> saveWho(SaveWho saveWho, String target);
}
