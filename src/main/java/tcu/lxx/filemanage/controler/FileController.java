package tcu.lxx.filemanage.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import tcu.lxx.filemanage.entity.Course;
import tcu.lxx.filemanage.entity.File;
import tcu.lxx.filemanage.entity.Office;
import tcu.lxx.filemanage.entity.Role;
import tcu.lxx.filemanage.excel.ExcelUtil;
import tcu.lxx.filemanage.service.CourseService;
import tcu.lxx.filemanage.service.FileService;
import tcu.lxx.filemanage.service.OfficeService;
import tcu.lxx.filemanage.service.RoleService;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Vector;

@Controller
public class FileController {
    //注入各种服务来实现数据库的操作
    @Autowired
    FileService fileService;
    @Autowired
    CourseService courseService;
    @Autowired
    OfficeService officeService;

    //我的记录对应的跳转路径

    @RequestMapping(value = "/fileList")
    public String fileList(ModelMap map) {
        //获取全部的file表格里边的数据,装入List集合
        List<File> list = fileService.getAllFileVo();
        //循环遍历list集合,让每一个File对象执行toString方法
        for (int i=0;i<list.size();i++){
            list.get(i).toString();
        }
        //map对象封装,以key-value形式存储,在页面上直接用 th:***使用
        map.addAttribute("filelist", list);
        //返回到file_list.html  界面
        return "file/file_list";

    }

    //跳转到增加页面的路径
    @RequestMapping(value = "/fileadd")
    public String fileadd(ModelMap map) {
        //查询出来所有的课程记录
        List<Course> courses = courseService.findCourseAll();
        //查询出所有办公室记录
        List<Office> offices = officeService.findOfficeAll();
        //new一个空的File对象传到界面去
        File file = new File();
        //以key-value形式来存储三个对象,以供界面使用
        map.addAttribute("file", file);
        map.addAttribute("courses", courses);
        map.addAttribute("offices", offices);
        //返回到file_list.html  界面
        return "file/file_add";

    }
    //执行增加的路径，传过来表单的对象，增加
    @RequestMapping(value = "/addFile")
    //form表单传过来的对象就是参数 @Param("file") File file
    public String add(@Param("file") File file) {
        //执行增加对象的方法,成功返回>0的数字,失败返回-1
        int a = fileService.addFile(file);
        if (a > 0) {
            return "success";
        }
        return "404";
    }
    //跳转到更新界面
    @RequestMapping(value = "/fileupdate")
    //路径传过来的@PathParam("fileid") String fileid
    public String fileupdate(@PathParam("fileid") String fileid,ModelMap map) {

        //查询出来该fileid所对应的File对象
        File file=fileService.selctById(Integer.valueOf(fileid));
        //查询所有课程
        List<Course> courses = courseService.findCourseAll();
        //查询所有办公室
        List<Office> offices = officeService.findOfficeAll();
        //以key-value形式将三个对象封装,以供界面太哦用
        map.addAttribute("file", file);
        map.addAttribute("courses", courses);
        map.addAttribute("offices", offices);
        //返回到file_update.html  更新界面
        return "file/file_update";

    }
    //执行更新的路径，传入File对象
    @RequestMapping(value = "/updatefile")
    //from 表单传过来的封装好的File对象,用来执行更新操作
    public String doupdate(@Param("file") File file) {

        //更新操作执行
        int a= fileService.update(file);
        if (a > 0) {
            return "success";
        } else {
            return "404";
        }

    }


//根据fileid 来删除对应的file记录
    @RequestMapping(value = "/deleteById")
    //路径传过来的 fileid
    public String delete(@PathParam("fileid") int fileid) {
//        执行删除操作
        int a = fileService.deleteFileById(fileid);
        if (a > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    //导出详细信息的路径,执行exportExcel方法
    @RequestMapping(value = "/createExcel")
    public void excel(HttpServletResponse response) {
        //表名称
        String fileName = "Lxx";
        //表头
        File header = new File("档案类型", "季度", "学院", "办公室", "专业名称", "课程名称", "班级","对应编码");

        //下边两句话设置反应头,弹出选择下载路径框
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=" +
                fileName + ".xls");

       //从数据库查出来所有的file记录
        List<File> list = fileService.getAllFileVo();
        //循环遍历list对象,执行每一个的tostring方法,构造所对应的编码
        for (int i=0;i<list.size();i++){
            list.get(i).toString();
        }
        //新建一个创建表格工具类
        ExcelUtil excelUtil = new ExcelUtil();
        //将三个参数传过去, 表头,工作表名称,所有file记录,设置好的响应头的响应response
        excelUtil.exportExcel(header, "档案记录", list, response);


    }
    //导出详细信息的路径,执行exportExcelOnlyCode方法
    @RequestMapping(value = "/createExcelOnlyCode")
    public void excelOnlyCode(HttpServletResponse response) {
        //表名称
        String fileName = "Lxx";

        //下边两句话设置反应头,弹出选择下载路径框
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=" +
                fileName + ".xls");
        //从数据库查出来所有的file记录
        List<File> list = fileService.getAllFileVo();
        //循环遍历list对象,执行每一个的tostring方法,构造所对应的编码
        for (int i=0;i<list.size();i++){
            list.get(i).toString();
        }
        //新建一个创建表格工具类
        ExcelUtil excelUtil = new ExcelUtil();

        //将三个参数传过去,工作表名称,所有file记录,设置好的响应头的响应response
        excelUtil.exportExcelOnlyCode("档案记录", list, response);


    }
}
