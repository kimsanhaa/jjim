package shopping.mall.domain.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;
import shopping.mall.domain.entities.Users;
import shopping.mall.domain.repositories.UsersRepository;
import shopping.mall.ui.api.request.SignUpUsersRequest;

import java.util.Collections;
import java.util.List;

class UsersServiceTest {

    private final UsersRepository usersRepository = Mockito.mock(UsersRepository.class);

    private UserService userService = new UserService(usersRepository);

    @Test
    public void sut는_중복된_이메일이_존재하면_예외가_발생한다(){
        //Arrange
        UserService sut = userService;
        SignUpUsersRequest request = new SignUpUsersRequest();
        String email = "java123@gmail.com";
        String password = "qwe123123";
        ReflectionTestUtils.setField(request,"email",email);
        ReflectionTestUtils.setField(request,"password",password);
        Exception actual = null;

        Users user = new Users();
        ReflectionTestUtils.setField(user,"email",email);
        ReflectionTestUtils.setField(user,"password",password);
        Mockito.when(usersRepository.findUsersByEmail(email))
                .thenReturn(Collections.singletonList(user));

        //Act
        try {
            sut.signUp(request);
        }catch (Exception e){
            actual = e;
        }

        //Assert
        Assertions.assertThat(actual).isNotNull();
        Assertions.assertThat(actual).isInstanceOf(IllegalStateException.class);
        Assertions.assertThat(actual.getMessage()).isEqualTo("중복된 이메일이 있습니다.");

    }
        public void sut는_성공적으로_회원가입을_한다(){
        //Arrange


        //Act

        //Assert
    }
}