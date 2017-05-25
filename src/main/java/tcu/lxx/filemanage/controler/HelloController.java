package tcu.lxx.filemanage.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import tcu.lxx.filemanage.entity.File;
import tcu.lxx.filemanage.entity.Office;
import tcu.lxx.filemanage.entity.UserInfo;
import tcu.lxx.filemanage.service.OfficeService;
import tcu.lxx.filemanage.service.UserService;

import java.util.List;

@Controller
public class HelloController {
    @Autowired
    OfficeService officeService;
    @Autowired
    UserService userService;
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
    @RequestMapping(value = "/register")
    public String zhuce(ModelMap map) {
        UserInfo userInfo=new UserInfo();
        //查询出所有办公室记录
        List<Office> offices = officeService.findOfficeAll();
        map.addAttribute("offices", offices);
        map.addAttribute("userinfo",userInfo);
        return "register";

    }
    @RequestMapping(value = "/addUser")
    public String add(@Param("userinfo") UserInfo userInfo) {
        int a = userService.addUser(userInfo);
        if (a > 0) {
            return "success";
        }
        return "404";
    }

}
