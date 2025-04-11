package se.lexicon;

import se.lexicon.dao.CourseDao;
import se.lexicon.dao.CourseDaoImpl;
import se.lexicon.dao.StudentDao;
import se.lexicon.dao.StudentDaoImpl;
import se.lexicon.model.Course;
import se.lexicon.model.Student;

import java.time.LocalDate;
import java.util.List;

public class StudentCourseManager {
    private static final StudentDao studentDao = new StudentDaoImpl();
    private static final CourseDao courseDao = new CourseDaoImpl();

    // Add a student
    public static void addStudent(String name, String email, String address) {
        Student student = new Student(0, name, email, address);
        studentDao.save(student);
        System.out.println("Student added: " + student);
    }

    // Add a course
    public static void addCourse(String courseName, String startDateStr, int durationWeeks) {
        LocalDate startDate = LocalDate.parse(startDateStr);
        Course course = new Course(0, courseName, startDate, durationWeeks);
        courseDao.save(course);
        System.out.println("Course added: " + course);
    }

    // View all students
    public static void viewAllStudents() {
        System.out.println("Listing all students:");
        for (Student student : studentDao.findAll()) {
            System.out.println(student);
        }
    }

    // View all courses
    public static void viewAllCourses() {
        System.out.println("Listing all courses:");
        for (Course course : courseDao.findAll()) {
            System.out.println(course);
        }
    }

    // Search for student by name
    public static void searchStudentByName(String name) {
        List<Student> students = studentDao.findByName(name);
        if (students.isEmpty()) {
            System.out.println("No student found with name: " + name);
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Search for course by name
    public static void searchCourseByName(String name) {
        List<Course> courses = courseDao.findByName(name);
        if (courses.isEmpty()) {
            System.out.println("No course found with name: " + name);
        } else {
            for (Course course : courses) {
                System.out.println(course);
            }
        }
    }

    // Edit student
    public static void editStudent(int studentId, String newName) {
        Student student = studentDao.findById(studentId);
        if (student != null) {
            student.setName(newName);
            studentDao.save(student);
            System.out.println("Updated Student: " + student);
        } else {
            System.out.println("Student not found.");
        }
    }

    // Edit course
    public static void editCourse(int courseId, String newCourseName) {
        Course course = courseDao.findById(courseId);
        if (course != null) {
            course.setCourseName(newCourseName);
            courseDao.save(course);
            System.out.println("Updated Course: " + course);
        } else {
            System.out.println("Course not found.");
        }
    }

    // Delete student
    public static void deleteStudent(int studentId) {
        Student student = studentDao.findById(studentId);
        if (student != null) {
            studentDao.delete(student);
            System.out.println("Student deleted: " + student);
        } else {
            System.out.println("Student not found.");
        }
    }

    // Delete course
    public static void deleteCourse(int courseId) {
        Course course = courseDao.findById(courseId);
        if (course != null) {
            courseDao.delete(course);
            System.out.println("Course deleted: " + course);
        } else {
            System.out.println("Course not found.");
        }
    }

    // Register student to a course
    public static void registerStudentToCourse(int studentId, int courseId) {
        Student student = studentDao.findById(studentId);
        Course course = courseDao.findById(courseId);

        if (student != null && course != null) {
            course.getStudents().add(student);
            courseDao.save(course);
            System.out.println("Student registered to course: " + student + " -> " + course);
        } else {
            System.out.println("Student or Course not found.");
        }
    }

    // Remove student from a course
    public static void removeStudentFromCourse(int studentId, int courseId) {
        Student student = studentDao.findById(studentId);
        Course course = courseDao.findById(courseId);

        if (student != null && course != null) {
            course.getStudents().remove(student);
            courseDao.save(course);
            System.out.println("Student removed from course: " + student + " -> " + course);
        } else {
            System.out.println("Student or Course not found.");
        }
    }
}

