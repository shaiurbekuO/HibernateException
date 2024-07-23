package main.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Enumerated;
import main.config.HibernateConfig;
import main.entity.Course;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;

import java.util.List;

public class CourseDaoImpl implements CourseDao{
    EntityManagerFactory entityManagerFactory = HibernateConfig.entityManagerFactory();
    @Override
    public String saveCourse(Course course) {
        if (course == null) {
            return "Course cannot be null";
        }
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
            return "Course saved successfully";
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
            return "Error saving course: " + e.getMessage();
        }
    }


    @Override
    public Course getCourseById(Long id) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            List<Course> course = entityManager.createQuery("select c from Course c where c.id = :id", Course.class)
                    .setParameter("id", id).getResultList();
            entityManager.getTransaction().commit();
            return course.isEmpty() ? null : course.get(0);

        }catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String updateCourse(Long id, Course course) {
        if (id == course.getId()) {
            return "Course cannot be null";
        }
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.createQuery("update Course c set c.courseName = :name, c.prise =:price, c.stadyFormat = :stadyFormat " +
                    "where c.id = :id").setParameter("name", course.getCourseName())
                    .setParameter("price", course.getPrise())
                    .setParameter("stadyFormat", course.getStadyFormat())
                    .setParameter("id", id)
                    .executeUpdate();
            entityManager.getTransaction().commit();
            return "Course updated successfully";
        }catch (HibernateException e){
            System.err.println(e.getMessage());
        }
        return "";
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = null;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            courses = entityManager.createQuery("select c from Course c", Course.class).getResultList();
            entityManager.getTransaction().commit();
            if (courses == null || courses.isEmpty()) throw new HibernateException("Course list is empty");
        }catch (HibernateException e){
            System.err.println(e.getMessage());

        }
        return courses;
    }

    @Override
    public String deleteCourse(Long id) {
        if (id == null){
            return "Course cannot be null";
        }
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, id);
            if (course == null) {
                entityManager.getTransaction().rollback();
                return "Course not found";
            }
            entityManager.remove(course);
            entityManager.getTransaction().commit();
            return "Course deleted successfully";
        }catch (HibernateException e){
            System.err.println(e.getMessage());

        }
        return "";
    }
}
