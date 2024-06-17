package shopping.mall.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import shopping.mall.domain.validator.TokenValidator;
import shopping.mall.infrastructure.jwt.TokenGeneratorImpl;
import shopping.mall.infrastructure.jwt.TokenValidatorImpl;

class AuthServiceTest {
    private TokenGeneratorImpl tokenGenerator = new TokenGeneratorImpl();
    private TokenValidator tokenValidator = new TokenValidatorImpl();
    AuthService authService = new AuthService(tokenGenerator, tokenValidator);

    @Test
    public void sut는_토큰을_생성한다(){
        //Arrange
        long userId = 1L;
        AuthService sut = authService;

        //act
        String actual = sut.tokenGenerate(userId);

        //Assert
        Assertions.assertThat(actual).isNotNull();
    }

    @Test
    public void sut는_expire_지나면_예외가_발생한다(){
        //todo 테스트코드 다시 작성하기
        //Arrange
        long userId = 1L;
        AuthService sut = authService;
        long expirationMs = 1;
        Exception actual = null;

        //act
        String token = sut.tokenGenerate(userId);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            sut.tokenValidate(token);
        }catch (Exception e){
            actual = e;
        }

        //Assert
        Assertions.assertThat(actual).isNotNull();
    }
}