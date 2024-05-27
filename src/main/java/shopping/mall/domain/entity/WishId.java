package shopping.mall.domain.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Embeddable
public class WishId implements Serializable {
    private String UserId;
    private String DeskId;
}
