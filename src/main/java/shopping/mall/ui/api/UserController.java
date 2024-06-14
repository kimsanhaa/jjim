package shopping.mall.ui.api;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import shopping.mall.domain.service.UserService;
import shopping.mall.ui.api.request.SignUpUsersRequest;

@AllArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public void userSignUp(@RequestBody SignUpUsersRequest request){
        userService.signUp(request);
    }
}
