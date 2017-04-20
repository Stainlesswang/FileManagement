package tcu.lxx.filemanage.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tcu.lxx.filemanage.entity.Role;
import tcu.lxx.filemanage.entity.UserInfo;
import tcu.lxx.filemanage.service.RoleService;
import tcu.lxx.filemanage.service.UserService;

import java.util.List;

/**
 * Created by stanwang on 2017/4/9.
 */
@RestController
public class RestControler {
    @Autowired
    RoleService roleService;
//    UserService userService;
    @RequestMapping("/string")
    public List<Role> string(){
       return roleService.getUserRole(1);
    }
}
