package shopping.mall.ui.api.request;

import lombok.Getter;

@Getter
public class RemoveWishListItemRequest {
    private Long itemId;
    private Long userId;
    private Long wishListId;
}
