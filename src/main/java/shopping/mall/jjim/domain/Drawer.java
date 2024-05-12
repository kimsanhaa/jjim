package shopping.mall.jjim.domain;

import lombok.Getter;

@Getter
public class Drawer {
    private String drawerKey;
    private String userKey;
    private String name;

    public Drawer(String drawerKey, String userKey, String name) {
        this.drawerKey = drawerKey;
        this.userKey = userKey;
        this.name = name;
    }
}
