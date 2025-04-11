package se.lexicon;

import se.lexicon.dao.CourseDao;
import se.lexicon.dao.CourseDaoImpl;
import se.lexicon.dao.StudentDao;
import se.lexicon.dao.StudentDaoImpl;
import se.lexicon.model.Course;
import se.lexicon.model.Student;

import java.time.LocalDate;
import java.util.Scanner;

public class CliUserInterface {
    // Create Scanner object to read user input
    private static final Scanner scanner = new Scanner(System.in);

    //create a menu

    public static void displayMenu() {
        System.out.println("Welcome to the Student and Course Management System");
        System.out.println("1. Add Student");
        System.out.println("2. Add Course");
        System.out.println("3. View All Students");
        System.out.println("4. View All Courses");
        System.out.println("5. Exit");
        System.out.print("Please select an option: ");
    }

    public static void main(String[] args) {
        // Initialize the Student and Course DAOs

        StudentDao studentDao = new StudentDaoImpl();
        CourseDao courseDao = new CourseDaoImpl();

        // Infinite loop for the menu
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Add a student
                    System.out.print("Enter Student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter Student Email: ");
                    String studentEmail = scanner.nextLine();
                    System.out.print("Enter Student Address: ");
                    String studentAddress = scanner.nextLine();
                    studentDao.save(new Student(studentId, studentName, studentEmail, studentAddress));
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    // Add a course
                    System.out.print("Enter Course ID: ");
                    int courseId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter Start Date (yyyy-MM-dd): ");
                    String startDate = scanner.nextLine();
                    System.out.print("Enter Week Duration: ");
                    int weekDuration = scanner.nextInt();
                    courseDao.save(new Course(courseId, courseName, LocalDate.parse(startDate), weekDuration));
                    System.out.println("Course added successfully!");
                    break;
                case 3:
                    // View all students
                    System.out.println("Students:");
                    for (Student student : studentDao.findAll()) {
                        System.out.println(student);
                    }
                    break;
                case 4:
                    // View all courses
                    System.out.println("Courses:");
                    for (Course course : courseDao.findAll()) {
                        System.out.println(course);
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option, please try again.");


            }
        }
    }
}