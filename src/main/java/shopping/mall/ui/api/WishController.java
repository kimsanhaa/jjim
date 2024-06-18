package shopping.mall.ui.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import shopping.mall.domain.service.WishlistService;
import shopping.mall.ui.api.request.CreateWishListRequest;
import shopping.mall.ui.api.request.DeleteWishListRequest;

@RequiredArgsConstructor
@RestController
public class WishController {
    private final WishlistService wishlistService;

    @PostMapping("/wishList")
    public ResponseEntity<Object> WishListCreate(CreateWishListRequest request){
        wishlistService.createWishList(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/wishList")
    public ResponseEntity<Object> WishListDelete(DeleteWishListRequest request){
        wishlistService.deleteWishList(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/wishListItem")
    public ResponseEntity<Object> WishListItemAdd(CreateWishListRequest request){
        wishlistService.createWishList(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/wishListItem")
    public ResponseEntity<Object> WishListItemDelete(DeleteWishListRequest request){
        wishlistService.deleteWishList(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
