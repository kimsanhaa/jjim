package shopping.mall.jjim.application.port.out;

import shopping.mall.jjim.domain.Drawer;

public interface DrawerPersistencePort {
    void createDrawer(Drawer drawer);
}
