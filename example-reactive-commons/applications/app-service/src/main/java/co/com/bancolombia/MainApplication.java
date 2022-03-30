package co.com.bancolombia;

import co.com.bancolombia.events.ReactiveDirectAsyncGateway;
import co.com.bancolombia.model.events.gateways.EventsGateway;
import co.com.bancolombia.model.transactionlog.TransactionLog;
import co.com.bancolombia.usecase.emitevent.EmitEventUseCase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {

        SpringApplication.run(MainApplication.class, args);
    }

    /*@Bean
    public CommandLineRunner commandLineRunner(EmitEventUseCase emitEventUseCase, ReactiveDirectAsyncGateway gateway){
        return (x)->{
            emitEventUseCase.sendTransactionalLog(TransactionLog.builder().build()).subscribe();
            gateway.sendMessageQuery("Envie query de prueba").doOnSuccess((y)-> System.out.println("respuesta del query:::: "+ y)).subscribe();
        }
    }*/

}
