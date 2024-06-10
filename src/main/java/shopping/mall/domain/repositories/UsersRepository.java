package shopping.mall.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shopping.mall.domain.entities.Users;

public interface UsersRepository extends JpaRepository<Users,Long> {
}

