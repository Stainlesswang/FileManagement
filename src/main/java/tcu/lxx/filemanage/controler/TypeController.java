package tcu.lxx.filemanage.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import tcu.lxx.filemanage.entity.Office;
import tcu.lxx.filemanage.entity.Type;
import tcu.lxx.filemanage.entity.Xueyuan;
import tcu.lxx.filemanage.service.TypeService;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class TypeController {
    @Autowired
    TypeService typeService;
    @RequestMapping(value = "/typelist")
    public String courseAll(ModelMap map) {

        List<Type> list = typeService.findTypeAll();

        map.addAttribute("typelist", list);

        return "type/type_list";

    }
    @RequestMapping(value = "/typeadd")
    public String fileadd(ModelMap map) {

        Type type = new Type();
        //以key-value形式来存储三个对象,以供界面使用
        map.addAttribute("type", type);

        return "type/type_add";

    }
    @RequestMapping(value = "/addtype")
    public String add(@Param("type") Type type) {
        //执行增加对象的方法,成功返回>0的数字,失败返回-1
        int a = typeService.addType(type);
        if (a > 0) {
            return "success";
        }
        return "404";
    }
    @RequestMapping(value = "/deletetype")
    //路径传过来的 fileid
    public String delete(@PathParam("typeid") String typeid) {
//        执行删除操作
        int a = typeService.deleteById(typeid);
        if (a > 0) {
            return "success";
        } else {
            return "error";
        }
    }
}
