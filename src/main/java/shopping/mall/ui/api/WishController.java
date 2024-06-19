package shopping.mall.ui.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shopping.mall.domain.entities.WishList;
import shopping.mall.domain.service.WishlistService;
import shopping.mall.ui.api.request.AddWishListRequest;
import shopping.mall.ui.api.request.CreateWishListRequest;
import shopping.mall.ui.api.request.DeleteWishListRequest;
import shopping.mall.ui.api.request.RemoveWishListItemRequest;

import java.util.List;

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
    public ResponseEntity<Object> WishListItemAdd(AddWishListRequest request){
        wishlistService.addWishList(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/wishList/items/{itemId}")
    public ResponseEntity<Object> removeFromWishlist(RemoveWishListItemRequest request){
        wishlistService.removeFromWishlist(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users/{usesId}/wishList")
    public ResponseEntity<Object> wishListGet(@PathVariable long userId){
        List<WishList> wishList = wishlistService.getWishList(userId);
        return new ResponseEntity<>(wishList,HttpStatus.OK);
    }
}
