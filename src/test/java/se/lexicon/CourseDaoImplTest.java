package se.lexicon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.dao.CourseDaoImpl;
import se.lexicon.model.Course;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.*;

public class CourseDaoImplTest {
    private CourseDaoImpl courseDao;

    @BeforeEach
    void setUp() {
        courseDao = new CourseDaoImpl();
    }

    @Test
    void testSaveAndFindById() {
        Course course = new Course(101, "Java", LocalDate.of(2025, 4, 17), 16);
        courseDao.save(course);
        Course found = courseDao.findById(101);
        assertNotNull(found);
        assertEquals("Java", found.getCourseName());

    }

    @Test
    void testFindByName() {
        Course course = new Course(102, "Python", LocalDate.of(2025, 8, 4), 30);
        courseDao.save(course);
        List<Course> found = courseDao.findByName("Python");
        assertFalse(found.isEmpty());
    }

    @Test
    void testFindByDate() {
        LocalDate date = LocalDate.of(2025, 6, 5);
        Course course = new Course(103, "JavaScript", date, 8);
        courseDao.save(course);
        List<Course> found = courseDao.findByDate(date);
        assertEquals(1, found.size());
    }
    @Test
    void testDelete(){
        Course course = new Course(104, "clean codes", LocalDate.of(2025, 8, 4), 30);
        courseDao.save(course);
        boolean deleted = courseDao.delete(course);
        assertTrue(deleted);
        assertNull(courseDao.findById(104));
    }

}
