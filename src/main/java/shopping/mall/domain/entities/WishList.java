package shopping.mall.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor
@Getter
@Entity
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "wishList", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Item> items = new ArrayList<>();

    private WishList(Users user, String name) {
        this.user = user;
        this.name = name;
    }

    public void addItems(Item item) {
        this.items.add(item);
    }
    public void removeItems(Item item) {
        this.items.remove(item);
    }

    public static WishList create(Users user, String name){
        if(name.length()>10){
            throw new IllegalArgumentException("이름은 10글자 이하이어야 합니다.");
        }
        if(isContainSpecialCharacter(name)){
            throw new IllegalArgumentException("이름엔 특수문자가 들어가면 안됩니다.");
        }
        return new WishList(user,name);
    }
    public static boolean isContainSpecialCharacter(String input) {
        Pattern pattern = Pattern.compile("[!@#$%^&*]");
        Matcher matcher = pattern.matcher(input);
        return matcher.find( );
    }
}
