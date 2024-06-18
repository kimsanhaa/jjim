package shopping.mall.domain.repositories;

import shopping.mall.domain.entities.WishList;

import java.util.List;
import java.util.Optional;

public interface WishListRepository {
    WishList save(WishList wishList);
    WishList findByUserIdAndWishListName(long userId, String wishListName);
    void deleteByWishListId(long wishListId);
    Optional<WishList> findByWishListId(long wishListId);
    List<WishList> findByUserId(Long userId);
}
