package se.lexicon.dao;

import se.lexicon.model.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class StudentDaoImpl implements StudentDao {
    private final List<Student> students = new ArrayList<>();

    //save method
    @Override
    public Student save(Student student) {
        // for loop to check if the student is already registered
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                return student;
            }
        }
        // add or save student to the list
        students.add(student);
        return student;
    }

    //find student by email method
    @Override
    public Student findByEmail(String email) {
        //loop through and find a match by email
        for (Student s : students) {
            if (s.getEmail().equalsIgnoreCase(email)) {
                return s;
            }
        }
        return null;
    }

    // find student by name method
    @Override
    public List<Student> findByName(String name) {
        List<Student> result = new ArrayList<>();
        //loop to add matching students
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                result.add(s);
            }
        }

        return result;
    }

    //find student by id method
    @Override
    public Student findById(int id) {
        //loop through the list to find student by id
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
    //get all students method

    @Override
    public List<Student> findAll() {
        return students;
    }
    //delete a student

    @Override
    public boolean delete(Student student) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getId() == student.getId()) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
