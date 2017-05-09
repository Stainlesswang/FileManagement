package tcu.lxx.filemanage.mapper;

import org.apache.ibatis.annotations.Select;
import tcu.lxx.filemanage.entity.Course;

import java.util.List;

public interface CourseMapper {
    @Select("select * from course")
    List<Course> findCourseAll();
}
