package shopping.mall.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shopping.mall.domain.entities.Users;
import shopping.mall.domain.repositories.UserMapper;
import shopping.mall.domain.repositories.UsersRepository;
import shopping.mall.ui.api.request.SignUpUsersRequest;

@AllArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final UserMapper userMapper;

    public void signUp(SignUpUsersRequest request) {
        Users user = new Users().create(request);
        if(userMapper.findUserIdByEmail(request.getEmail()) != null){
            throw new IllegalArgumentException("중복된 이메일이 있습니다.");
        }
        usersRepository.save(user);

    }
}
