package shopping.mall.ui.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shopping.mall.domain.entities.WishList;
import shopping.mall.application.WishlistService;
import shopping.mall.ui.api.request.AddWishListRequest;
import shopping.mall.ui.api.request.CreateWishListRequest;
import shopping.mall.ui.api.request.DeleteWishListRequest;
import shopping.mall.ui.api.request.RemoveWishListItemRequest;
import shopping.mall.ui.api.response.WishListResponse;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class WishController {
    private final WishlistService wishlistService;

    @PostMapping("/wishList")
    public ResponseEntity<Object> WishListCreate(@RequestBody CreateWishListRequest request){
        wishlistService.createWishList(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/wishList")
    public ResponseEntity<Object> WishListDelete(@RequestBody DeleteWishListRequest request){
        wishlistService.deleteWishList(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/wishListItem")
    public ResponseEntity<Object> WishListItemAdd(@RequestBody AddWishListRequest request){
        wishlistService.addWishList(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/wishList/items/{itemId}")
    public ResponseEntity<Object> removeFromWishlist(@RequestBody RemoveWishListItemRequest request){
        wishlistService.removeFromWishlist(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/wishList")
    public ResponseEntity<Object> wishListGet(@PathVariable("userId") Long userId){
        List<WishListResponse> wishList = wishlistService.getWishList(userId);
        return new ResponseEntity<>(wishList,HttpStatus.OK);
    }
}
