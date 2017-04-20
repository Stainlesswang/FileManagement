package tcu.lxx.filemanage.controler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import tcu.lxx.filemanage.entity.File;
import tcu.lxx.filemanage.entity.Role;
import tcu.lxx.filemanage.excel.ExcelUtil;
import tcu.lxx.filemanage.service.FileService;
import tcu.lxx.filemanage.service.RoleService;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Vector;

/**
 * Created by stanwang on 2017/4/12.
 */
@Controller
public class FileController {
    @Autowired
    FileService fileService;
    @RequestMapping(value = "/fileList")
    public String fileList(ModelMap map){
        List<File> list=fileService.getAllFile();
        map.addAttribute("filelist",list);
        return "file/file_list";

    }
    @RequestMapping(value = "/fileadd")
    public String fileadd(ModelMap map){
      File file=new File();
        map.addAttribute("file",file);
        return "file/file_add";

    }
    @RequestMapping(value = "/addFile")
    public String add(@Param("file") File file){
        System.out.println(file.getJidu_id());
        int a=fileService.addFile(file);
        if(a>0){
            return "success";
        }
        return "404";
    }
    @RequestMapping(value = "/deleteById")
    public String delete(@PathParam("fileid") int fileid){
        System.out.println("cardid    "+fileid);
        int a=fileService.deleteFileById(fileid);
        if(a>0){
            return "success";
        }else{
            return "error";
        }
    }
    @RequestMapping(value = "/createExcel")
    public void excel(HttpServletResponse response){
        //表名称
        String fileName="Lxx";
        //表头

        File header =new File("档案类型","季度","学院","办公室","专业名称","课程名称","班级");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename="+
               fileName+ ".xls");
        List<File> list=fileService.getAllFileVo();
        ExcelUtil excelUtil=new ExcelUtil();
        Boolean ok=excelUtil.exportExcel(header,"档案记录",list,response);
//        if (ok){
//            return "success";
//        }else {
//            return "404";
//        }


    }
}
