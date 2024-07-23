package main;

import main.config.HibernateConfig;
import main.entity.Course;
import main.enums.StadyFormat;
import main.service.CourseService;
import main.service.CourseServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        CourseService courseService = new CourseServiceImpl();
//        System.out.println(courseService.saveCourse(new Course("Java", 14000, StadyFormat.ONLINE)));
//        System.out.println(courseService.getCourseById(3L));
//        System.out.println(courseService.getAllCourses());
//        System.out.println(courseService.updateCourse(1L, new Course("PHP", 15000, StadyFormat.OFFLINE)));
        System.out.println(courseService.deleteCourse(3L));
    }
}
