package shopping.mall.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shopping.mall.domain.generator.TokenGenerator;
import shopping.mall.domain.validator.TokenValidator;
import shopping.mall.infrastructure.jwt.TokenGeneratorImpl;
@RequiredArgsConstructor
public class AuthService {
    private final TokenGenerator tokenGenerator;
    private final TokenValidator tokenValidator;

    public String tokenGenerate(long userId, long expireMs) {
        return tokenGenerator.generate(userId ,expireMs);
    }

    public boolean tokenValidate(String token) {
        return tokenValidator.validate(token);
    }
}
