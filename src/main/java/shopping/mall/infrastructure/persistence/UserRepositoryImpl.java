package shopping.mall.infrastructure.persistence;


import lombok.RequiredArgsConstructor;
import shopping.mall.domain.entities.Users;
import shopping.mall.domain.repositories.UserRepository;
import shopping.mall.infrastructure.persistence.jpa.UserJpaRepository;

import java.util.List;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJpaRepository;

    @Override
    public List<Users> findUsersByEmail(String email) {
        return userJpaRepository.findUsersByEmail(email);
    }

    @Override
    public Users save(Users users) {
        return userJpaRepository.save(users);
    }
}
