package shopping.mall.ui.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import shopping.mall.domain.service.UserService;
import shopping.mall.ui.api.request.SignUpUsersRequest;

@AllArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<Object> userSignUp(
            @RequestBody SignUpUsersRequest request
    ) {
        userService.signUp(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
