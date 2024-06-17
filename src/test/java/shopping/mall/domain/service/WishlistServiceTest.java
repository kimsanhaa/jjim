package shopping.mall.domain.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;
import shopping.mall.domain.entities.Users;
import shopping.mall.domain.entities.WishList;
import shopping.mall.domain.repositories.UserRepository;
import shopping.mall.domain.repositories.WishListRepository;
import shopping.mall.ui.api.request.AddWishListRequest;

import java.util.Optional;

class WishlistServiceTest {
    private WishListRepository wishListRepository = Mockito.mock(WishListRepository.class);
    private UserRepository userRepository = Mockito.mock(UserRepository.class);
    private WishlistService wishlistService = new WishlistService(wishListRepository,userRepository);

    @Test
    public void sut는_요청된_userId_값이_null이면_예외가_발생한다(){
        //Arrange
        WishlistService sut = wishlistService;
        Exception actual = null;
        long userId = 11;
        String wishListName = "여름옷";

        Mockito.when(userRepository.findByUserId(userId))
                .thenReturn(Optional.empty());

        AddWishListRequest request = new AddWishListRequest();
        ReflectionTestUtils.setField(request,"userId",userId);
        ReflectionTestUtils.setField(request,"wishListName",wishListName);

        //Act
        try {
            wishlistService.createWishList(request);
        }catch (Exception e){
            actual = e;
        }
        //Assert
        Assertions.assertThat(actual).isNotNull();
        Assertions.assertThat(actual).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThat(actual.getMessage()).isEqualTo("사용자를 찾을 수 없습니다.");
    }

    @Test
    public void sut는_중복된_찜서랍의_이름이면_예외가_발생한다(){
        //Arrange
        WishlistService sut = wishlistService;
        Exception actual = null;
        long userId = 11;
        String wishListName = "여름옷";

        Users users = Users.create("java@java.com","javajavajava");
        ReflectionTestUtils.setField(users,"id",userId);
        Mockito.when(userRepository.findByUserId(userId))
                .thenReturn(Optional.of(users));

        WishList wishList = WishList.create(users,wishListName);
        Mockito.when(wishListRepository.findByUserIdAndWishListName(userId,wishListName))
                .thenReturn(wishList);

        AddWishListRequest request = new AddWishListRequest();
        ReflectionTestUtils.setField(request,"userId",userId);
        ReflectionTestUtils.setField(request,"wishListName",wishListName);

        //Act
        try {
            wishlistService.createWishList(request);
        }catch (Exception e){
            actual = e;
        }
        //Assert
        Assertions.assertThat(actual).isNotNull();
        Assertions.assertThat(actual).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThat(actual.getMessage()).isEqualTo("이미 있는 찜 서랍 이름입니다.");
    }
}