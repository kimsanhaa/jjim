package shopping.mall.domain.repositories;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import shopping.mall.domain.entities.Users;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Disabled
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void sut는_user를_저장한다(){
        //Arrange
        UserRepository sut = userRepository;
        String email = "jjim1234@jjim.com";
        String password = "jjim1234";
        Users user = new Users(email, password);

        //Act
        Users users = sut.save(user);

        //Assert
        Assertions.assertThat(users).isNotNull();
        Assertions.assertThat(users.getEmail()).isEqualTo(email);
        Assertions.assertThat(users.getPassword()).isEqualTo(password);
    }
}