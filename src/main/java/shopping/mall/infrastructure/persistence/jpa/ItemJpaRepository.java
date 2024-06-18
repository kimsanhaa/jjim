package shopping.mall.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import shopping.mall.domain.entities.Item;

public interface ItemJpaRepository extends JpaRepository<Item,Long> {
}
