package shopping.mall.domain.repositories;

import shopping.mall.domain.entities.Item;

import java.util.Optional;

public interface ItemRepository {
    Optional<Item> findByItemId(Long ItemId);
}
