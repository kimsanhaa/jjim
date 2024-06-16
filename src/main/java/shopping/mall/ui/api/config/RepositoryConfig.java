package shopping.mall.ui.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shopping.mall.domain.repositories.ProductRepository;
import shopping.mall.domain.repositories.UserRepository;
import shopping.mall.infrastructure.persistence.ProductRepositoryImpl;
import shopping.mall.infrastructure.persistence.UserRepositoryImpl;
import shopping.mall.infrastructure.persistence.jpa.UserJpaRepository;

@Configuration
public class RepositoryConfig {
    @Bean
    public UserRepository userRepository(UserJpaRepository rep){
        return new UserRepositoryImpl(rep);
    }
}
