package shopping.mall.domain.entities;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import shopping.mall.ui.api.request.SignUpUsersRequest;

class UsersTest {

    @Test
    public void sut는_password_길이가_5글자보다_작으면_예외가_발생한다(){
        //Arrange
        String email = "test@test.com";
        String password = "test";
        Exception actual = null;

        //Act
        try {
            Users users = Users.create(email,password);
        }catch (Exception e){
            actual = e;
        }
        //Assert
        Assertions.assertThat(actual).isNotNull();
        Assertions.assertThat(actual).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThat(actual.getMessage()).isEqualTo("비밀번호는 5글자 이상이어야 합니다.");
    }

    @Test
    public void sut는_email_형식에_맞지_않으면_예외가_발생한다(){
        //Arrange
        String email = "test";
        String password = "test";
        Exception actual = null;

        //Act
        try {
            Users users = Users.create(email,password);
        }catch (Exception e){
            actual = e;
        }
        //Assert
        Assertions.assertThat(actual).isNotNull();
        Assertions.assertThat(actual).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThat(actual.getMessage()).isEqualTo("이메일이 올바르지 않습니다.");

    }
}