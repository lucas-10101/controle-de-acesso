package tms.backend.controledeacesso.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import tms.backend.controledeacesso.providers.IdentityProvider;
import tms.backend.controledeacesso.providers.identityprovider.KeycloakIdentityProvider;

@Configuration
public class SimpleBeansConfiguration {

    @Bean
    public IdentityProvider identityProvider() {
        return new KeycloakIdentityProvider();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }
}
