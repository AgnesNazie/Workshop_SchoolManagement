package se.lexicon.dao;

import se.lexicon.model.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    private final List<Course> courses = new ArrayList<>();

    @Override
    public Course save(Course course) {
        // for loop to check if the student is already registered
        for (Course c : courses) {
            if (c.getId() == course.getId()) {
                return course;
            }
        }
        //add course if it is not found
        courses.add(course);
        return course;
    }

    //find by id method
    @Override
    public Course findById(int id) {
        //loop through and find a match by email
        for (Course c : courses) {
            if (c.getId() == (id)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Course> findByName(String name) {
        List<Course> result = new ArrayList<>();
        //loop to add matching students
        for (Course c : courses) {
            if (c.getCourseName().equalsIgnoreCase(name)) {
                result.add(c);
            }
        }
        return result;
    }

    @Override
    public List<Course> findByDate(LocalDate date) {
        List<Course> result = new ArrayList<>();
        //loop to add matching students
        for (Course c : courses) {
            if (c.getStartDate().equals(date)) {
                result.add(c);
            }
        }
        return result;

    }

    @Override
    public List<Course> findAll() {
        return courses;
    }

    @Override
    public boolean delete(Course course) {
        Iterator<Course> iterator = courses.iterator();
        while (iterator.hasNext()) {
            Course c = iterator.next();
            if (c.getId() == course.getId()) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
