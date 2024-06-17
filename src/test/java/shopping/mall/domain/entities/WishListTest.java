package shopping.mall.domain.entities;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WishListTest {

    @Test
    public void sut는_name에_특수문자가_들어오면_예외가_발생한다() {
        //Arrange
        Users user = Users.create("java@java.com","testtest");
        String wishListName = "여름옷@@@";
        Exception actual = null;

        //Act
        try {
            WishList sut = WishList.create(user,wishListName);
        }catch (Exception e){
            actual = e;
        }
        //Assert
        Assertions.assertThat(actual).isNotNull();
        Assertions.assertThat(actual).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThat(actual.getMessage()).isEqualTo("이름엔 특수문자가 들어가면 안됩니다.");
    }

    @Test
    public void sut는_name의_길이가_10보다_크면_예외가_발생한다() {
        //Arrange
        Users user = Users.create("java@java.com","testtest");
        String wishListName = "10글자가넘어가면예외가발생합니다";
        Exception actual = null;

        //Act
        try {
            WishList sut = WishList.create(user,wishListName);
        }catch (Exception e){
            actual = e;
        }
        //Assert
        Assertions.assertThat(actual).isNotNull();
        Assertions.assertThat(actual).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThat(actual.getMessage()).isEqualTo("이름은 10글자 이하이어야 합니다.");
    }
}