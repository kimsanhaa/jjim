package shopping.mall.ui.api;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import shopping.mall.domain.service.UsersService;
import shopping.mall.ui.api.request.SignUpUsersRequest;

@AllArgsConstructor
@RestController
public class UserController {
    private final UsersService usersService;

    @PostMapping("/users")
    public void userSignUp(@RequestBody SignUpUsersRequest request){
        usersService.signUp(request);

    }
}
