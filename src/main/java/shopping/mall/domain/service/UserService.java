package shopping.mall.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shopping.mall.domain.entities.Users;
import shopping.mall.domain.repositories.UserRepository;
import shopping.mall.ui.api.request.SignUpUsersRequest;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void signUp(SignUpUsersRequest request) {
        Users user = new Users().create(request);
        if(!userRepository.findUsersByEmail(request.getEmail()).isEmpty()){
            throw new IllegalStateException("중복된 이메일이 있습니다.");
        }
        userRepository.save(user);
    }
}
