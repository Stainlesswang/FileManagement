package tcu.lxx.filemanage.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import tcu.lxx.filemanage.entity.Course;
import tcu.lxx.filemanage.entity.Office;
import tcu.lxx.filemanage.entity.Xueyuan;
import tcu.lxx.filemanage.mapper.XueyuanMapper;
import tcu.lxx.filemanage.service.OfficeService;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class OfficeController {
    @Autowired
    OfficeService officeService;

    @Autowired
    XueyuanMapper xueyuanMapper;

    @RequestMapping(value = "/officelist")
    public String courseAll(ModelMap map) {

        List<Office> list = officeService.findOfficeAll();

        map.addAttribute("officelist", list);

        return "office/office_list";

    }
    @RequestMapping(value = "/officeadd")
    public String fileadd(ModelMap map) {
        //查询出来所有的课程记录
        List<Xueyuan> xueyuans = xueyuanMapper.findOneToMany();

        //new一个空的File对象传到界面去
        Office office = new Office();
        //以key-value形式来存储三个对象,以供界面使用
        map.addAttribute("office", office);
        map.addAttribute("xueyuans", xueyuans);

        return "office/office_add";

    }
    @RequestMapping(value = "/addoffice")
    public String add(@Param("office") Office office) {
        //执行增加对象的方法,成功返回>0的数字,失败返回-1
        int a = officeService.addOffice(office);
        if (a > 0) {
            return "success";
        }
        return "404";
    }
    @RequestMapping(value = "/deleteoffice")
    //路径传过来的 fileid
    public String delete(@PathParam("officeid") String officeid) {
//        执行删除操作
        int a = officeService.deleteById(officeid);
        if (a > 0) {
            return "success";
        } else {
            return "error";
        }
    }
}
