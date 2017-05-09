package tcu.lxx.filemanage.service;

import org.springframework.stereotype.Service;
import tcu.lxx.filemanage.entity.Course;

import java.util.List;


public interface CourseService {
    public List<Course> findCourseAll();
}
