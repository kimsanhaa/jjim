package shopping.mall.jjim.adapter.out.persistence;

import lombok.Getter;
import shopping.mall.jjim.domain.Drawer;

@Getter
public class DrawerSaveDto {
    private String drawerKey;
    private String userKey;
    private String name;

    private DrawerSaveDto(String drawerKey, String userKey, String name) {
        this.drawerKey = drawerKey;
        this.userKey = userKey;
        this.name = name;
    }
    public static DrawerSaveDto from (Drawer drawer){
        return new DrawerSaveDto(drawer.getDrawerKey(),drawer.getUserKey(),drawer.getName());
    }
}
