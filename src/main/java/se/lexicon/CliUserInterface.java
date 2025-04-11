package se.lexicon;

import java.util.Scanner;


public class CliUserInterface {
    private static final Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {
        System.out.println("\nWelcome to the Student and Course Management System");
        System.out.println("1. Add Student");
        System.out.println("2. Add Course");
        System.out.println("3. View All Students");
        System.out.println("4. View All Courses");
        System.out.println("5. Search for Student by Name");
        System.out.println("6. Search for Course by Name");
        System.out.println("7. Edit Student");
        System.out.println("8. Edit Course");
        System.out.println("9. Delete Student");
        System.out.println("10.Delete Course");
        System.out.println("11.Register Student to Course");
        System.out.println("12.Remove Student from Course");
        System.out.println("13.Exit");
        System.out.print("Please select an option: ");
    }

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter Student Email: ");
                    String studentEmail = scanner.nextLine();
                    System.out.print("Enter Student Address: ");
                    String studentAddress = scanner.nextLine();
                    StudentCourseManager.addStudent(studentName, studentEmail, studentAddress);
                    break;
                case 2:
                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter Start Date (YYYY-MM-DD): ");
                    String startDate = scanner.nextLine();
                    System.out.print("Enter Duration in Weeks: ");
                    int duration = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    StudentCourseManager.addCourse(courseName, startDate, duration);
                    break;
                case 3:
                    StudentCourseManager.viewAllStudents();
                    break;
                case 4:
                    StudentCourseManager.viewAllCourses();
                    break;
                case 5:
                    System.out.print("Enter Student Name to search: ");
                    String studentSearchName = scanner.nextLine();
                    StudentCourseManager.searchStudentByName(studentSearchName);
                    break;
                case 6:
                    System.out.print("Enter Course Name to search: ");
                    String courseSearchName = scanner.nextLine();
                    StudentCourseManager.searchCourseByName(courseSearchName);
                    break;
                case 7:
                    System.out.print("Enter Student ID to edit: ");
                    int studentIdToEdit = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new Student Name: ");
                    String newStudentName = scanner.nextLine();
                    StudentCourseManager.editStudent(studentIdToEdit, newStudentName);
                    break;
                case 8:
                    System.out.print("Enter Course ID to edit: ");
                    int courseIdToEdit = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new Course Name: ");
                    String newCourseName = scanner.nextLine();
                    StudentCourseManager.editCourse(courseIdToEdit, newCourseName);
                    break;
                case 9:
                    System.out.print("Enter Student ID to delete: ");
                    int studentIdToDelete = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    StudentCourseManager.deleteStudent(studentIdToDelete);
                    break;
                case 10:
                    System.out.print("Enter Course ID to delete: ");
                    int courseIdToDelete = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    StudentCourseManager.deleteCourse(courseIdToDelete);
                    break;
                case 11:
                    System.out.print("Enter Student ID: ");
                    int studentIdToRegister = scanner.nextInt();
                    System.out.print("Enter Course ID: ");
                    int courseIdToRegister = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    StudentCourseManager.registerStudentToCourse(studentIdToRegister, courseIdToRegister);
                    break;
                case 12:
                    System.out.print("Enter Student ID: ");
                    int studentIdToRemove = scanner.nextInt();
                    System.out.print("Enter Course ID: ");
                    int courseIdToRemove = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    StudentCourseManager.removeStudentFromCourse(studentIdToRemove, courseIdToRemove);
                    break;
                case 13:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}