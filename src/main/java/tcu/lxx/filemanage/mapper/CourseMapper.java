package tcu.lxx.filemanage.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tcu.lxx.filemanage.entity.Course;
import tcu.lxx.filemanage.entity.File;

import java.util.List;

public interface CourseMapper {
    @Insert("INSERT INTO course (course_id,course,pid)\n" +
            "VALUES(#{course_id},#{course},#{pid})")
    public int addCourse(Course course);

    @Delete("delete from course where course_id=#{courseid}")
    public int deleteById(String courseid);

    @Update("update course set course_id=#{course_id},course=#{course},pid=#{pid}" +
            " where course_id=#{course_id}")
    public int update(Course course);
      @Select("select * from course")
    List<Course> findCourseAll();
}
