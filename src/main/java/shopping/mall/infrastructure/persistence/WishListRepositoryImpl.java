package shopping.mall.infrastructure.persistence;

import lombok.AllArgsConstructor;
import shopping.mall.domain.entities.WishList;
import shopping.mall.domain.repositories.WishListRepository;
import shopping.mall.infrastructure.persistence.jpa.WishListJpaRepository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public WishList findByWishListId(long wishListId) {
        return wishListJpaRepository.findById(wishListId)
                .orElseThrow(() -> new IllegalArgumentException("wishListId 값이 올바르지 않습니다."));
    }

    @Override
    public List<WishList> findByUserId(Long userId) {
        return wishListJpaRepository.findByUserId(userId);
    }

    @Override
    public boolean existsWishListByUserIdAndItemId(Long userId, Long itemId) {
        return wishListJpaRepository.existsWishListByUserIdAndItemId(userId,itemId);
    }
}
