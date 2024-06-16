package shopping.mall.application;

import org.springframework.stereotype.Component;
import shopping.mall.domain.generator.TokenGenerator;
import shopping.mall.domain.validator.TokenValidator;
import shopping.mall.infrastructure.jwt.TokenGeneratorImpl;

public class AuthService {
    private TokenGenerator tokenGenerator;
    private TokenValidator tokenValidator;

}
