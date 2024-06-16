package shopping.mall.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import shopping.mall.domain.entities.Product;

public interface ProductJpaRepository extends JpaRepository<Product,Long> {
}
