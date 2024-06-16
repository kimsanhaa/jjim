package shopping.mall.ui.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shopping.mall.application.AuthService;

@Configuration
public class ServiceConfig {

    @Bean
    public AuthService authService() {
        return new AuthService();
    }
}
