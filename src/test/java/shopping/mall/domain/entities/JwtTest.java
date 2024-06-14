package shopping.mall.domain.entities;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;
import shopping.mall.domain.vo.Jwt;

class JwtTest {

    @Test
    public void sut는_jwt토큰을_생성한다(){
        //Arrange
        long id = 1L;
        String email = "jjim@jjim.com";
        String password = "jjim";
        Users users = createUsers(id, email, password);

        //act
        Jwt jwt = new Jwt(users);

        //Assert
        Assertions.assertThat(jwt).isNotNull();
    }

    @Test
    public void sut는_jwt토큰을_검증한다(){
        //Arrange
        long id = 1L;
        String email = "jjim@jjim.com";
        String password = "jjim";
        Users users = createUsers(id, email, password);
        Jwt jwt = new Jwt(users);

        //act
        boolean actual = jwt.validate(jwt.getToken(), users);

        //Assert
        Assertions.assertThat(actual).isTrue();
    }

    private Users createUsers(long id,String email, String password){
        Users users = new Users(email, password);
        ReflectionTestUtils.setField(users,"id",id);
        return users;
    }
}