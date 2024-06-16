package shopping.mall.domain.repositories;

import shopping.mall.domain.entities.Users;

import java.util.List;

public interface UserRepository {
     List<Users> findUsersByEmail(String email);
     Users save(Users users);

}

