package shopping.mall.domain.service.WishListServiceTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;
import shopping.mall.Reflection.ReflectionProvider;
import shopping.mall.domain.entities.Item;
import shopping.mall.domain.entities.Users;
import shopping.mall.domain.entities.WishList;
import shopping.mall.domain.repositories.ItemRepository;
import shopping.mall.domain.repositories.UserRepository;
import shopping.mall.domain.repositories.WishListRepository;
import shopping.mall.domain.service.WishlistService;
import shopping.mall.ui.api.exception.BusinessException;
import shopping.mall.ui.api.request.AddWishListRequest;
import shopping.mall.ui.api.request.CreateWishListRequest;
import shopping.mall.ui.api.request.DeleteWishListRequest;


public class DeleteWishListTest {

    private final WishListRepository wishListRepository = Mockito.mock(WishListRepository.class);
    private final UserRepository userRepository = Mockito.mock(UserRepository.class);
    private final ItemRepository itemRepository  = Mockito.mock(ItemRepository.class);
    private final WishlistService wishlistService = new WishlistService(wishListRepository,userRepository,itemRepository);

    @Test
    public void sut는_wishList조회시_userId와_요청받은_userId가_다르면_예외가_발생한다(){
        //Arrange
        WishlistService sut = wishlistService;
        BusinessException actual = null;
        Long userId = 1L;
        String email = "test@test.com";
        String password = "test123123123";

        Long wishListId = 1L;
        String wishListName = "testWishList";

        Long requestUserId = 2L;
        Long requestWishListId = 3L;

        Users users = ReflectionProvider.getUsers(userId, email, password);
        WishList wishList = ReflectionProvider.getWishList(wishListId,wishListName,users);

        DeleteWishListRequest request = ReflectionProvider.getDeleteWishListRequest(requestUserId, requestWishListId);
        Mockito.when(wishListRepository.findByWishListId(request.getWishListId()))
                .thenReturn(wishList);

        //Act
        try {
            sut.deleteWishList(request);
        }catch (BusinessException e){
            actual = e;
        }

        //Assert
        Assertions.assertThat(actual).isNotNull();
        Assertions.assertThat(actual).isInstanceOf(BusinessException.class);
        Assertions.assertThat(actual.getCode()).isEqualTo(1902);
    }
}
