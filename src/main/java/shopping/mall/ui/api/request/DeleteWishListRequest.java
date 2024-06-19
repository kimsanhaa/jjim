package shopping.mall.ui.api.request;

import lombok.Getter;

@Getter
public class DeleteWishListRequest {
    private long wishListId;
    private long userId;
}
