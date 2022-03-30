package co.com.bancolombia.config;

import co.com.bancolombia.model.constants.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConstants {
    @Value("${spring.application.name}")
    private String appName;

    @Value("${spring.node.name}")
    private String nameWho;

    @Bean
    public Constants getConstants() {
        return Constants.builder()
                .appName(appName)
                .nameWho(nameWho)
                .build();
    }
}
