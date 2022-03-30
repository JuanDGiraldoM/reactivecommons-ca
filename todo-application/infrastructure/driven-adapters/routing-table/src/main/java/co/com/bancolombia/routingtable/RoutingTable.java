package co.com.bancolombia.routingtable;


import co.com.bancolombia.model.savewho.SaveWho;
import co.com.bancolombia.model.task.gateways.TaskRoutingTable;
import reactor.core.publisher.Mono;

import java.util.concurrent.ConcurrentHashMap;

public class RoutingTable implements TaskRoutingTable {

    private static final ConcurrentHashMap<String, String> routingTable = new ConcurrentHashMap<>();

    public Boolean containsKey(String name) {
        return routingTable.containsKey(name);
    }

    public String getRouteName(String name) {
        return routingTable.get(name);
    }

    public Mono<Void> registerRoute(SaveWho saveWho) {
        return Mono.defer(() -> {
            routingTable.put(saveWho.getWho(), saveWho.getAppName());
            return Mono.empty();
        });
    }
}
