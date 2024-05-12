package shopping.mall.jjim.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shopping.mall.jjim.application.port.In.DrawerCreateCommand;
import shopping.mall.jjim.application.service.DrawerService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/drawer")
public class DrawerController {
    private DrawerService drawerService;

    @PostMapping("/")
    public void drawerCreate(@RequestBody DrawerCreateCommand command){
        drawerService.createDrawer(command);
    }
    public void drawerDelete(){

    }
    public void drawers(){
    }
}
