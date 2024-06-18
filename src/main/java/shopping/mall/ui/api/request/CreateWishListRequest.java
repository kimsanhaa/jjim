package shopping.mall.ui.api.request;

import lombok.Getter;

@Getter
public class CreateWishListRequest {
    private long userId;
    private String wishListName;
}
