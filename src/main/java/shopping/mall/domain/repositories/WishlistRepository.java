package shopping.mall.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shopping.mall.domain.entities.Wishlist;
@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
}
