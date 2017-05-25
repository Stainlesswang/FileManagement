package tcu.lxx.filemanage.service;

import org.springframework.stereotype.Service;
import tcu.lxx.filemanage.entity.Course;

import java.util.List;


public interface CourseService {
    public int addCourse(Course course);
    public int deleteById(String courseid);
    public int update(Course course);
    public List<Course> findCourseAll();
}
