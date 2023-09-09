package lpirito.ms.appoints.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {

    @Bean("apiConsumer")
    public RestTemplate registerRestTemplate() {
        return new RestTemplate();
    }
}
