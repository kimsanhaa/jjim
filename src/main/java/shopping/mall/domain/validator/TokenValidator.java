package shopping.mall.domain.validator;

import shopping.mall.domain.entities.Users;

public interface TokenValidator {
    boolean validate(String token);
}
