package shopping.mall.domain.entities;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Float price;

}
