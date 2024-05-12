package shopping.mall.jjim.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shopping.mall.common.UseCase;
import shopping.mall.jjim.application.port.In.DrawerCreateCommand;
import shopping.mall.jjim.application.port.In.DrawerUserCase;
import shopping.mall.jjim.application.port.out.DrawerPersistencePort;
import shopping.mall.jjim.domain.Drawer;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class DrawerService implements DrawerUserCase {
    private final DrawerPersistencePort drawerPersistencePort;

    @Override
    public boolean createDrawer(DrawerCreateCommand command) {
        String drawerKey = String.valueOf(UUID.randomUUID());
        Drawer drawer = new Drawer(drawerKey, command.getUserKey(), command.getName());
        drawerPersistencePort.createDrawer(drawer);
        return false;
    }
}
