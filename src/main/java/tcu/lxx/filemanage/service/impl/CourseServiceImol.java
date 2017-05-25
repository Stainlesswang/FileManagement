package tcu.lxx.filemanage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcu.lxx.filemanage.entity.Course;
import tcu.lxx.filemanage.mapper.CourseMapper;
import tcu.lxx.filemanage.service.CourseService;

import java.util.List;

@Service
public class CourseServiceImol implements CourseService {
    @Autowired
    CourseMapper courseMapper;

    @Override
    public int addCourse(Course course) {
        return courseMapper.addCourse(course);
    }

    @Override
    public int deleteById(String courseid) {
        return courseMapper.deleteById(courseid);
    }

    @Override
    public int update(Course course) {
        return courseMapper.update(course);
    }

    @Override
    public List<Course> findCourseAll() {
        return courseMapper.findCourseAll();
    }
}
