package shopping.mall.domain.repositories;

import shopping.mall.domain.entities.WishList;

public interface WishListRepository {
    WishList save(WishList wishList);
    WishList findByUserIdAndWishListName(long userId, String wishListName);
    void deleteByWishListId(long wishListId);
}
