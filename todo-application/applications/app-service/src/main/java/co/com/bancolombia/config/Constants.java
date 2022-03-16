package co.com.bancolombia.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class Constants {
    @Value("${spring.application.name}")
    private String appName;

    @Value("${spring.node.name}")
    private String nameWho;
}
