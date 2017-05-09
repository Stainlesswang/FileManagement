package tcu.lxx.filemanage.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tcu.lxx.filemanage.entity.*;
import tcu.lxx.filemanage.mapper.XueyuanMapper;
import tcu.lxx.filemanage.mapper.ZhuanyeMapper;
import tcu.lxx.filemanage.service.FileService;
import tcu.lxx.filemanage.service.RoleService;
import tcu.lxx.filemanage.service.UserService;

import java.util.List;

@RestController
public class RestControler {
    @Autowired
    RoleService roleService;
    @Autowired
    XueyuanMapper xueyuanMapper;
    @Autowired
    FileService fileService;

    @RequestMapping("/test/xueyuan")
    public List<Xueyuan> string() {

        List<Xueyuan> xueyuan = xueyuanMapper.findOneToMany();
        return xueyuan;

    }

    @RequestMapping("/test/zhuanye")
    public  List<File> zhuanye() {

        List<File> list = fileService.getAllFileVo();
        for (int i=0;i<list.size();i++){
            list.get(i).toString();
        }
        return list;

    }


    @RequestMapping("/test/a")
    public List<File> a() {

//        List<Xueyuan> xueyuan = xueyuanMapper.findOneToMany();
//        return xueyuan;
        List<File> list = fileService.getAllFileVo();
        for (int i=0;i<list.size();i++){
            list.get(i).toString();
        }
        return list;
    }
    @RequestMapping(value = "test/updatefile")
    public File doupdate(@Param("file") File file) {

        System.out.println(file.getBanji_id());
        int a= fileService.update(file);
//        if (a > 0) {
//            return "success";
//        } else {
//            return "404";
//        }
        return file;

    }
}
