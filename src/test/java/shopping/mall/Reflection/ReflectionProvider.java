package shopping.mall.Reflection;

import org.springframework.test.util.ReflectionTestUtils;
import shopping.mall.domain.entities.Users;
import shopping.mall.domain.entities.WishList;
import shopping.mall.ui.api.request.AddWishListRequest;
import shopping.mall.ui.api.request.CreateWishListRequest;
import shopping.mall.ui.api.request.DeleteWishListRequest;
import shopping.mall.ui.api.request.RemoveWishListItemRequest;

public class ReflectionProvider {

    public static AddWishListRequest getAddWishListRequest(Long wishListId, Long itemId, Long userId) {
        AddWishListRequest request = new AddWishListRequest();
        ReflectionTestUtils.setField(request,"wishListId", wishListId);
        ReflectionTestUtils.setField(request,"itemId", itemId);
        ReflectionTestUtils.setField(request,"userId", userId);
        return request;
    }

    public static RemoveWishListItemRequest getRemoveWishListItemRequest(Long wishListId, Long itemId, Long userId) {
        RemoveWishListItemRequest request = new RemoveWishListItemRequest();
        ReflectionTestUtils.setField(request,"wishListId", wishListId);
        ReflectionTestUtils.setField(request,"itemId", itemId);
        ReflectionTestUtils.setField(request,"userId", userId);
        return request;
    }

    public static DeleteWishListRequest getDeleteWishListRequest(Long userId , Long wishListId) {
        DeleteWishListRequest request = new DeleteWishListRequest();
        ReflectionTestUtils.setField(request,"userId", userId);
        ReflectionTestUtils.setField(request,"wishListId", wishListId);
        return request;
    }

    public static CreateWishListRequest getCreateWishListRequest(Long userId, String wishListName) {
        CreateWishListRequest request = new CreateWishListRequest();
        ReflectionTestUtils.setField(request,"userId", userId);
        ReflectionTestUtils.setField(request,"wishListName", wishListName);
        return request;
    }

    public static Users getUsers(Long userId, String email, String password) {
        Users users = new Users();
        ReflectionTestUtils.setField(users,"id", userId);
        ReflectionTestUtils.setField(users,"email", email);
        ReflectionTestUtils.setField(users,"password", password);
        return users;
    }

    public static WishList getWishList(Long wishListId, String wishListName, Users user){
        WishList wishList = new WishList();
        ReflectionTestUtils.setField(wishList,"id", wishListId);
        ReflectionTestUtils.setField(wishList,"name", wishListName);
        ReflectionTestUtils.setField(wishList,"user", user);
        return wishList;
    }

}
