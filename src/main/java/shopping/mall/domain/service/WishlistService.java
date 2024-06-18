package shopping.mall.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;
import shopping.mall.domain.entities.Item;
import shopping.mall.domain.entities.Users;
import shopping.mall.domain.entities.WishList;
import shopping.mall.domain.repositories.ItemRepository;
import shopping.mall.domain.repositories.UserRepository;
import shopping.mall.domain.repositories.WishListRepository;
import shopping.mall.ui.api.request.AddWishListRequest;
import shopping.mall.ui.api.request.CreateWishListRequest;
import shopping.mall.ui.api.request.DeleteWishListRequest;

import java.util.List;

@AllArgsConstructor
public class WishlistService {
    private final WishListRepository wishListRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public void createWishList(CreateWishListRequest request){
        Users user = userRepository.findByUserId(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        if(wishListRepository.findByUserIdAndWishListName(request.getUserId(), request.getWishListName()) != null){
            throw new IllegalArgumentException("이미 있는 찜 서랍 이름입니다.");
        }

        WishList wishList = WishList.create(user, request.getWishListName());
        wishListRepository.save(wishList);
    }
    @Transactional
    public void deleteWishList(DeleteWishListRequest request){
        try {
            wishListRepository.deleteByWishListId(request.getUserId());
        }catch (EmptyResultDataAccessException e){
            throw new IllegalArgumentException("wishListId 값이 올바르지 않습니다.");
        }
    }
    @Transactional
    public void addWishList(AddWishListRequest request){
        WishList wishList = wishListRepository.findByWishListId(request.getWishListId())
                .orElseThrow(() -> new IllegalArgumentException("wishListId 값이 올바르지 않습니다."));

        // todo 상품이 다른 wishList에 있는지 확인하는 로직 추가 필요

        Item item = itemRepository.findByItemId(request.getItemId())
                .orElseThrow(() -> new IllegalArgumentException("itemId 값이 올바르지 않습니다.") );

        wishList.addItems(item);
    }
    @Transactional
    public void removeFromWishlist(long itemId){
        Item item = itemRepository.findByItemId(itemId)
                .orElseThrow(() -> new IllegalArgumentException("itemId 값이 올바르지 않습니다."));

        item.getWishList().removeItems(item);
    }

    @Transactional(readOnly = true)
    public List<WishList> getWishList(long userId){
         return wishListRepository.findByUserId(userId);
    }
}
