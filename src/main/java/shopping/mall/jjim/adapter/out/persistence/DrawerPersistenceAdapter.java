package shopping.mall.jjim.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import shopping.mall.common.PersistenceAdapter;
import shopping.mall.jjim.application.port.out.DrawerPersistencePort;
import shopping.mall.jjim.domain.Drawer;

@RequiredArgsConstructor
@PersistenceAdapter
public class DrawerPersistenceAdapter implements DrawerPersistencePort {
    private final DrawerMapper drawerMapper;

    @Override
    public void createDrawer(Drawer drawer) {
        DrawerSaveDto dsd = DrawerSaveDto.from(drawer);
        drawerMapper.save(dsd);
    }
}
