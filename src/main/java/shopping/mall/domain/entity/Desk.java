package shopping.mall.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Desk {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    @OneToMany(mappedBy = "Desk",cascade = CascadeType.ALL)
    private List<Wish> wishList = new ArrayList<>();
}
