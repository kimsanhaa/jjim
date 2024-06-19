package shopping.mall.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shopping.mall.domain.entities.Users;
import shopping.mall.domain.entities.WishList;

import java.util.List;

public interface WishListJpaRepository extends JpaRepository<WishList, Long> {
    WishList findWishListByUserIdAndName(Long userId, String wishListName);
    List<WishList> findByUserId(Long userId);
    @Query("SELECT COUNT(wl) > 0 FROM WishList wl JOIN wl.items item " +
            "WHERE item.id = :itemId AND wl.user.id = :userId")
    boolean existsWishListByUserIdAndItemId(@Param("userId") Long userId, @Param("itemId") Long itemId);

}
