package shopping.mall.ui.api.request;

import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class SignUpUsersRequest {
    private String email;
    private String password;
}
