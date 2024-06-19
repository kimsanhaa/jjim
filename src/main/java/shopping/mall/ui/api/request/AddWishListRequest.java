package shopping.mall.ui.api.request;

import lombok.Getter;

@Getter
public class AddWishListRequest {
    long wishListId;
    long itemId;
    long userId;
}
