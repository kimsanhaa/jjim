package shopping.mall.domain.repositories;

import org.springframework.data.repository.query.Param;
import shopping.mall.domain.entities.WishList;

import java.util.List;
import java.util.Optional;

public interface WishListRepository {
    WishList save(WishList wishList);
    WishList findByUserIdAndWishListName(long userId, String wishListName);
    void deleteByWishListId(long wishListId);
    WishList findByWishListId(long wishListId);
    List<WishList> findByUserId(Long userId);
    boolean existsWishListByUserIdAndItemId(Long userId,Long itemId);

}
