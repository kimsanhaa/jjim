package shopping.mall.ui.api.response;

import lombok.Getter;

@Getter
public class WishListResponse{
    private Long wishListId;
    private String wishListName;

    public WishListResponse(Long wishListId, String wishListName) {
        this.wishListId = wishListId;
        this.wishListName = wishListName;
    }
}
