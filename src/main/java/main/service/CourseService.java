package main.service;

import main.entity.Course;

import java.util.List;

public interface CourseService {
    String saveCourse(Course course);
    Course getCourseById(Long id);
    String updateCourse(Long id, Course course);
    List<Course> getAllCourses();
    String deleteCourse(Long id);
}
