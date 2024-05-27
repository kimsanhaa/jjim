package shopping.mall.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Wish {
    @EmbeddedId
    private WishId id;
    @Column(name = "product_id")
    private String ProductId;

    @ManyToOne
    @JoinColumn(name = "desk_id")
    private Desk desk;
}
