package se.lexicon.dao;

import se.lexicon.model.Course;
import java.time.LocalDate;
import java.util.List;

public interface CourseDao {
    Course save (Course course);
    Course findByEmail (int id);
    List<Course> findByName(String name);
    List<Course> findById(LocalDate date);
    List<Course> findAll();
    boolean delete(Course course);
}
