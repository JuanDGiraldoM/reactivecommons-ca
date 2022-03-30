package co.com.bancolombia.api;
import co.com.bancolombia.model.message.Message;
import co.com.bancolombia.model.transactionlog.TransactionLog;
import co.com.bancolombia.usecase.emitcommand.EmitCommandUseCase;
import co.com.bancolombia.usecase.emitevent.EmitEventUseCase;
import co.com.bancolombia.usecase.emitquery.EmitQueryUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
//    private final MyUseCase useCase;
    private final EmitEventUseCase useCase;
    private final EmitCommandUseCase commandUseCase;
    private final EmitQueryUseCase queryUseCase;


    @PostMapping(path = "/event")
    public Mono<String> createdLog(@RequestBody TransactionLog transactionLog) {
        return useCase.sendTransactionalLog(transactionLog).thenReturn("OK!");
    }

    @GetMapping(path = "/command")
    public Mono<String> commandName() {
        return commandUseCase.sendMessageCommand(Message
                .builder()
                .name("Mensaje")
                .description("Este es un mensaje de comando")
                .build()).thenReturn("OK");
    }

    @GetMapping(path = "/query")
    public Mono<Object> queryMessage() {
        return queryUseCase
                .sendMessageQuery("Este es un mensaje de query");
    }
}
