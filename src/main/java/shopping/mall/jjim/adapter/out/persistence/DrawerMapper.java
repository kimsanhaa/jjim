package shopping.mall.jjim.adapter.out.persistence;

import shopping.mall.jjim.domain.Drawer;

public interface DrawerMapper {
    int save(DrawerSaveDto dsd);
    void delete();
    void find();
    void update();
}
