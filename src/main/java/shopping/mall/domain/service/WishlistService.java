package shopping.mall.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shopping.mall.infrastructure.persistence.jpa.WishListJpaRepository;

@RequiredArgsConstructor
@Component
public class WishlistService {
    private final WishListJpaRepository wishListJpaRepository;

    public void addWishList(){
    }
    public void removeWishList(){
    }
    public void createWishList(){
    }
    public void getWishList(){
    }
}
