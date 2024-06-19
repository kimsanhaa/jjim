package shopping.mall.ui.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shopping.mall.application.AuthService;
import shopping.mall.domain.generator.TokenGenerator;
import shopping.mall.domain.repositories.ItemRepository;
import shopping.mall.domain.repositories.UserRepository;
import shopping.mall.domain.repositories.WishListRepository;
import shopping.mall.application.UserService;
import shopping.mall.application.WishlistService;
import shopping.mall.domain.validator.TokenValidator;
import shopping.mall.infrastructure.jwt.TokenGeneratorImpl;
import shopping.mall.infrastructure.jwt.TokenValidatorImpl;

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
    @Bean
    public WishlistService wishlistService(
            WishListRepository wishListRepository,
            UserRepository userRepository,
            ItemRepository itemRepository
    ) {
        return new WishlistService(wishListRepository, userRepository,itemRepository);
    }
}
