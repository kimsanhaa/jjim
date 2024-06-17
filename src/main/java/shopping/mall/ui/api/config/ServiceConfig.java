package shopping.mall.ui.api.config;

import org.apache.catalina.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shopping.mall.application.AuthService;
import shopping.mall.domain.generator.TokenGenerator;
import shopping.mall.domain.repositories.UserRepository;
import shopping.mall.domain.service.UserService;
import shopping.mall.domain.validator.TokenValidator;
import shopping.mall.infrastructure.jwt.TokenGeneratorImpl;
import shopping.mall.infrastructure.jwt.TokenValidatorImpl;
import shopping.mall.infrastructure.persistence.UserRepositoryImpl;

@Configuration
public class ServiceConfig {

    @Bean
    public TokenGenerator tokenGenerator(){
        return new TokenGeneratorImpl();
    }
    @Bean
    public TokenValidator tokenValidator(){
        return new TokenValidatorImpl();
    }

    @Bean
    public AuthService authService(TokenGenerator tokenGenerator,TokenValidator tokenValidator) {
        return new AuthService(tokenGenerator,tokenValidator);
    }
    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }
}
