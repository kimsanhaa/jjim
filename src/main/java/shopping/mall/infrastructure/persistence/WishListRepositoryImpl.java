package shopping.mall.infrastructure.persistence;

import lombok.AllArgsConstructor;
import shopping.mall.domain.entities.WishList;
import shopping.mall.domain.repositories.WishListRepository;
import shopping.mall.infrastructure.persistence.jpa.WishListJpaRepository;

@AllArgsConstructor
public class WishListRepositoryImpl implements WishListRepository {
    private final WishListJpaRepository wishListJpaRepository;

    @Override
    public WishList save(WishList wishList) {
        return wishListJpaRepository.save(wishList);
    }

    @Override
    public WishList findByUserIdAndWishListName(long userId, String wishListName) {
        return wishListJpaRepository.findWishListByUserIdAndName(userId,wishListName);
    }

    @Override
    public void deleteByWishListId(long wishListId) {
         wishListJpaRepository.deleteById(wishListId);
    }
}
