package shopping.mall.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shopping.mall.domain.entities.Users;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
     List<Users> findUsersByEmail(String email);
}

