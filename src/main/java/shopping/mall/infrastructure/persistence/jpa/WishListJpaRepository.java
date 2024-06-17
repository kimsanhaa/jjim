package shopping.mall.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shopping.mall.domain.entities.Users;
import shopping.mall.domain.entities.WishList;

public interface WishListJpaRepository extends JpaRepository<WishList, Long> {
    WishList findWishListByUserIdAndName(Long userId, String wishListName);
}
