package shopping.mall.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class WishListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "wishlist_id", nullable = false)
    private WishList wishlist;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
