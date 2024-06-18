package shopping.mall.ui.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shopping.mall.domain.repositories.ItemRepository;
import shopping.mall.domain.repositories.UserRepository;
import shopping.mall.domain.repositories.WishListRepository;
import shopping.mall.infrastructure.persistence.ItemRepositoryImpl;
import shopping.mall.infrastructure.persistence.UserRepositoryImpl;
import shopping.mall.infrastructure.persistence.WishListRepositoryImpl;
import shopping.mall.infrastructure.persistence.jpa.ItemJpaRepository;
import shopping.mall.infrastructure.persistence.jpa.UserJpaRepository;
import shopping.mall.infrastructure.persistence.jpa.WishListJpaRepository;

@Configuration
public class RepositoryConfig {
    @Bean
    public UserRepository userRepository(UserJpaRepository rep){
        return new UserRepositoryImpl(rep);
    }
    @Bean
    public WishListRepository wishListRepository(WishListJpaRepository rep){
        return new WishListRepositoryImpl(rep);
    }

    @Bean
    public ItemRepository itemRepository(ItemJpaRepository rep){
        return new ItemRepositoryImpl(rep);
    }
}
