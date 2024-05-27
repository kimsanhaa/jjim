package shopping.mall.ui.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeskController {

    @GetMapping("/desks")
    public void readDesk(){
    }
    @PostMapping("/desks")
    public void createDesk(){
    }
    @DeleteMapping("/desks")
    public void deleteDesk(){
    }
}
