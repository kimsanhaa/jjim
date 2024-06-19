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
import shopping.mall.ui.api.exception.BusinessException;
import shopping.mall.ui.api.exception.ExceptionResponse;
import shopping.mall.ui.api.request.AddWishListRequest;
import shopping.mall.ui.api.request.CreateWishListRequest;
import shopping.mall.ui.api.request.DeleteWishListRequest;
import shopping.mall.ui.api.request.RemoveWishListItemRequest;

import java.util.List;

import static shopping.mall.ui.api.exception.ExceptionResponse.*;

@AllArgsConstructor
public class WishlistService {
    private final WishListRepository wishListRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public void createWishList(CreateWishListRequest request){
        Users user = userRepository.findByUserId(request.getUserId())
            .orElseThrow(() -> new BusinessException(NotFoundUserId));

        if(wishListRepository.findByUserIdAndWishListName(request.getUserId(), request.getWishListName()) != null){
            throw new BusinessException(DuplicateWishListName);
        }

        WishList wishList = WishList.create(user, request.getWishListName());
        wishListRepository.save(wishList);
    }

    @Transactional
    public void deleteWishList(DeleteWishListRequest request){
        if(wishListRepository.findByWishListId(request.getWishListId()).getUser().getId() != request.getUserId()){
            throw new BusinessException(NotFoundWishListId);
        }
        wishListRepository.deleteByWishListId(request.getWishListId());
    }

    @Transactional
    public void addWishList(AddWishListRequest request){
        WishList wishList = wishListRepository.findByWishListId(request.getWishListId());

        if(wishList.getUser().getId() != request.getUserId()){
            throw new BusinessException(NotFoundWishListId);
        }
        if (wishListRepository.existsWishListByUserIdAndItemId(request.getUserId(), request.getItemId())) {
            throw new BusinessException(DuplicateItem);
        }

        Item item = itemRepository.findByItemId(request.getItemId());
        wishList.addItems(item);
    }

    @Transactional
    public void removeFromWishlist(RemoveWishListItemRequest request){
        WishList wishList = wishListRepository.findByWishListId(request.getWishListId());

        if(wishList.getUser().getId() != request.getUserId()){
            throw new BusinessException(NotFoundWishListId);
        }
        Item item = itemRepository.findByItemId(request.getItemId());
        wishList.removeItems(item);
    }

    @Transactional(readOnly = true)
    public List<WishList> getWishList(long userId){
         return wishListRepository.findByUserId(userId);
    }
}
