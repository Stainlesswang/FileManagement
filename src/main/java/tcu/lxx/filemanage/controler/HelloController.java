package tcu.lxx.filemanage.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping(value = "/login")
    public String hello() {
        System.out.println("==================================login");
        return "login";

    }

    @RequestMapping(value = "/home")
    public String home() {
        System.out.println("==================================index");
        return "index";

    }


}
