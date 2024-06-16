package shopping.mall.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import shopping.mall.domain.entities.Users;

import java.util.List;

public interface UserJpaRepository extends JpaRepository<Users,Long> {
     List<Users> findUsersByEmail(String email);
}

