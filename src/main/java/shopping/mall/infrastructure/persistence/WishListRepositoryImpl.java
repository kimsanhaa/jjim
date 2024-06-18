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
    public Optional<WishList> findByWishListId(long wishListId) {
        return wishListJpaRepository.findById(wishListId);
    }

    @Override
    public List<WishList> findByUserId(Long userId) {
        return wishListJpaRepository.findByUserId(userId);
    }
}
