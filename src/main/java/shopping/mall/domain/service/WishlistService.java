package shopping.mall.domain.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import shopping.mall.domain.entities.Users;
import shopping.mall.domain.entities.WishList;
import shopping.mall.domain.repositories.UserRepository;
import shopping.mall.domain.repositories.WishListRepository;
import shopping.mall.infrastructure.persistence.jpa.WishListJpaRepository;
import shopping.mall.ui.api.request.AddWishListRequest;

@AllArgsConstructor
public class WishlistService {
    private final WishListRepository wishListRepository;
    private final UserRepository userRepository;

    public void createWishList(AddWishListRequest request){
        Users user = userRepository.findByUserId(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        if(wishListRepository.findByUserIdAndWishListName(request.getUserId(), request.getWishListName()) != null){
            throw new IllegalArgumentException("이미 있는 찜 서랍 이름입니다.");
        }

        WishList wishList = WishList.create(user, request.getWishListName());
        wishListRepository.save(wishList);
    }

    public void deleteWishList(long wishListId){
        try {
            wishListRepository.deleteByWishListId(wishListId);
        }catch (EmptyResultDataAccessException e){
            throw new IllegalArgumentException("wishListId 값이 올바르지 않습니다.");
        }
    }

    public void addWishList(){
    }
    public void getWishList(){
    }
}
