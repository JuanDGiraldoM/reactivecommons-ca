package co.com.bancolombia.model.task.gateways;

import co.com.bancolombia.model.savewho.SaveWho;
import reactor.core.publisher.Mono;

public interface TaskRoutingTable {

    Boolean containsKey(String name);

    String getRouteName(String name) ;

    Mono<Void> registerRoute(SaveWho saveWho);
}
