package se.lexicon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.dao.StudentDaoImpl;
import se.lexicon.model.Student;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StudentDaoImplTest {
    private StudentDaoImpl studentDao;

    @BeforeEach
    void setUp() {
        studentDao = new StudentDaoImpl();
    }

    @Test
    void testSaveAndFindById() {
        Student student = new Student(1, "Agnes", "agnes@gmail.com", "London");
        studentDao.save(student);
        Student found = studentDao.findById(1);
        assertNotNull(found);
        assertEquals("Agnes", found.getName());
    }

    @Test
    void testFindByEmail() {
        Student student = new Student(2, "Mehrdad", "mehrdad@gmail.com", "Vaxjo");
        studentDao.save(student);
        Student found = studentDao.findByEmail("mehrdad@gmail.com");
        assertNotNull(found);
        assertEquals(2, found.getId());

    }

    @Test
    void testFindByName() {
        Student s1 = new Student(4, "David", "david@gmail.com", "Centrum");
        Student s2 = new Student(5, "David", "david2@gmail.com", "Centrum 3");
        Student s3 = new Student(6, "Andreas", "Andreas@gmail.com", "Void Central");
        Student s4 = new Student(7, "Monica", "monica@gmail.com", "Paris");
        studentDao.save(s1);
        studentDao.save(s2);
        studentDao.save(s3);
        List<Student> found = studentDao.findByName("David");
        assertEquals(2, found.size());
    }

    @Test
    void testDelete() {
        Student student = new Student(3, "Simon", "simon@gmail.com", "New York");
        studentDao.save(student);
        boolean deleted = studentDao.delete(student);
        assertTrue(deleted);
        assertNull(studentDao.findById(3));
    }

}

