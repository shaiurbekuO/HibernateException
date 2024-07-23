package main.service;

import main.dao.CourseDao;
import main.dao.CourseDaoImpl;
import main.entity.Course;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    private  CourseDao courseDao = new CourseDaoImpl();
    @Override
    public String saveCourse(Course course) {
        return courseDao.saveCourse(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseDao.getCourseById(id);
    }

    @Override
    public String updateCourse(Long id, Course course) {
           return courseDao.updateCourse(id, course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    @Override
    public String deleteCourse(Long id) {
        return courseDao.deleteCourse(id);
    }
}
