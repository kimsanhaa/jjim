package shopping.mall.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import shopping.mall.domain.entities.WishListItem;

public interface WishListItemJpaRepository extends JpaRepository<WishListItem, Long> {
}
