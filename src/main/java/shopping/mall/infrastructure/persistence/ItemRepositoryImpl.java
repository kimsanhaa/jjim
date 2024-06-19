package shopping.mall.infrastructure.persistence;

import lombok.RequiredArgsConstructor;
import shopping.mall.domain.entities.Item;
import shopping.mall.domain.repositories.ItemRepository;
import shopping.mall.infrastructure.persistence.jpa.ItemJpaRepository;

import java.util.Optional;

@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepository {
    private  final ItemJpaRepository itemJpaRepository;

    @Override
    public Item findByItemId(Long itemId) {
        return itemJpaRepository.findById(itemId).orElseThrow(() -> new IllegalArgumentException("itemId 값이 올바르지 않습니다."));
    }
}
