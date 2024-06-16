package shopping.mall.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import shopping.mall.domain.entities.WishList;

public interface WishListJpaRepository extends JpaRepository<WishList, Long> {
}
