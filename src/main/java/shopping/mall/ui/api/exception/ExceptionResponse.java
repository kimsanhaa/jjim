package shopping.mall.ui.api.exception;

import lombok.Getter;

@Getter
public enum ExceptionResponse {
    OK("OK",1000),
    //user
    NotFoundUserId("userId 값이 올바르지 않습니다.",1901),
    //wishList
    NotFoundWishListId("wishListId 값이 올바르지 않습니다.",1902),
    DuplicateWishListName("중복된 wishListName입니다.",1903),
    DuplicateItem("이미 찜 목록에 등록된 상품입니다.",1904);

    private String message;
    private int code;

    ExceptionResponse(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
