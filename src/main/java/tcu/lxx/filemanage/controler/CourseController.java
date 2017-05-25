package tcu.lxx.filemanage.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import tcu.lxx.filemanage.entity.Course;
import tcu.lxx.filemanage.entity.File;
import tcu.lxx.filemanage.entity.Office;
import tcu.lxx.filemanage.entity.Xueyuan;
import tcu.lxx.filemanage.mapper.XueyuanMapper;
import tcu.lxx.filemanage.service.CourseService;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class CourseController {
    @Autowired
    CourseService courseService;
    @Autowired
    XueyuanMapper xueyuanMapper;


    @RequestMapping(value = "/courselist")
    public String courseAll(ModelMap map) {

        List<Course> list = courseService.findCourseAll();
        //courselist名字list值
        map.addAttribute("courselist", list);

        return "course/course_list";

    }
    @RequestMapping(value = "/courseadd")
    public String fileadd(ModelMap map) {
        //查询出来所有的课程记录
        List<Xueyuan> xueyuans = xueyuanMapper.findOneToMany();

        //new一个空的File对象传到界面去
        Course course = new Course();
        //以key-value形式来存储三个对象,以供界面使用
        map.addAttribute("course", course);
        map.addAttribute("xueyuans", xueyuans);

        return "course/course_add";

    }
    @RequestMapping(value = "/addcourse")
    public String add(@Param("course") Course course) {
        //执行增加对象的方法,成功返回>0的数字,失败返回-1
        int a = courseService.addCourse(course);
        if (a > 0) {
            return "success";
        }
        return "404";
    }
    @RequestMapping(value = "/deletecourse")
    //路径传过来的 courseid
    public String delete(@PathParam("courseid") String courseid) {
//        执行删除操作
        int a = courseService.deleteById(courseid);
        if (a > 0) {
            return "success";
        } else {
            return "error";
        }
    }
}
