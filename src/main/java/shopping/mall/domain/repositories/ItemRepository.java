package shopping.mall.domain.repositories;

import shopping.mall.domain.entities.Item;

import java.util.Optional;

public interface ItemRepository {
    Item findByItemId(Long ItemId);
}
