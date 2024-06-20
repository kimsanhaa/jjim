package shopping.mall.ui.api.response;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GetWishListResponse {
    List<WishListResponse> wishListResponseList = new ArrayList<>();

    public GetWishListResponse(List<WishListResponse> wishListResponseList) {
        this.wishListResponseList = wishListResponseList;
    }
}

