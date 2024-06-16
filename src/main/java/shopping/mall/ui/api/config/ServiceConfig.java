package shopping.mall.ui.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shopping.mall.application.AuthService;
import shopping.mall.domain.generator.TokenGenerator;
import shopping.mall.domain.validator.TokenValidator;
import shopping.mall.infrastructure.jwt.TokenGeneratorImpl;
import shopping.mall.infrastructure.jwt.TokenValidatorImpl;

@Configuration
public class ServiceConfig {

    @Bean
    public AuthService authService() {
        TokenGenerator tokenGenerator = new TokenGeneratorImpl();
        TokenValidator tokenValidator = new TokenValidatorImpl();
        return new AuthService(tokenGenerator,tokenValidator);
    }
}
