package shopping.mall.ui.api.request;

import lombok.Getter;

@Getter
public class AddWishListRequest {
    private long userId;
    private String wishListName;
}
