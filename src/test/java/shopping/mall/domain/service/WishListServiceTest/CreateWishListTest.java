package shopping.mall.domain.service.WishListServiceTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;
import shopping.mall.Reflection.ReflectionProvider;
import shopping.mall.domain.entities.Users;
import shopping.mall.domain.entities.WishList;
import shopping.mall.domain.repositories.ItemRepository;
import shopping.mall.domain.repositories.UserRepository;
import shopping.mall.domain.repositories.WishListRepository;
import shopping.mall.domain.service.WishlistService;
import shopping.mall.ui.api.exception.BusinessException;
import shopping.mall.ui.api.request.CreateWishListRequest;

import java.util.Optional;

public class CreateWishListTest {
    private final WishListRepository wishListRepository = Mockito.mock(WishListRepository.class);
    private final UserRepository userRepository = Mockito.mock(UserRepository.class);
    private final ItemRepository itemRepository  = Mockito.mock(ItemRepository.class);
    private final WishlistService wishlistService = new WishlistService(wishListRepository,userRepository,itemRepository);

    @Test
    public void sut는_userId값이_올바르지_않으면_예외가_발생한다(){
        //Arrange
        WishlistService sut = wishlistService;
        BusinessException actual = null;
        Long userId = 1L;
        CreateWishListRequest request = ReflectionProvider.getCreateWishListRequest(userId, "TestWishListName");

        Mockito.when(userRepository.findByUserId(userId))
                .thenReturn(Optional.empty());
        //Act
        try {
            sut.createWishList(request);
        }catch (BusinessException e){
            actual = e;
        }

        //Assert
        Assertions.assertThat(actual).isNotNull();
        Assertions.assertThat(actual).isInstanceOf(BusinessException.class);
        Assertions.assertThat(actual.getCode()).isEqualTo(1901);
    }

    @Test
    public void sut는_중복된_wishListName이_존재하면_예외가_발생한다(){
        //Arrange
        WishlistService sut = wishlistService;
        BusinessException actual = null;
        long userId = 11L;
        String email = "java@java.com";
        String password = "qwe123qwe123";

        String wishListName = "여름옷";

        Users users = ReflectionProvider.getUsers(userId,email,password);

        Mockito.when(userRepository.findByUserId(userId))
                .thenReturn(Optional.of(users));

        WishList wishList = WishList.create(users,wishListName);
        Mockito.when(wishListRepository.findByUserIdAndWishListName(userId,wishListName))
                .thenReturn(wishList);

        CreateWishListRequest request = ReflectionProvider.getCreateWishListRequest(userId, wishListName);

        //Act
        try {
            sut.createWishList(request);
        }catch (BusinessException e){
            actual = e;
        }
        //Assert
        Assertions.assertThat(actual).isNotNull();
        Assertions.assertThat(actual).isInstanceOf(BusinessException.class);
        Assertions.assertThat(actual.getCode()).isEqualTo(1903);
    }
}
