package se.lexicon.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Course {
    //fields
    private static int sequencer = 0;
    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student> students;
    //constructor

    public Course(String courseName, LocalDate startDate, int weekDuration) {
        this.id = ++sequencer;
        setCourseName(courseName);
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.students = new ArrayList<>();
    }
    //getter for id

    public int getId() {
        return id;
    }
    //getter for courseName

    public String getCourseName() {
        return courseName;
    }
    //setter for courseName

    public void setCourseName(String courseName) {
        if (courseName == null || courseName.trim().isEmpty())
            throw new IllegalArgumentException("Course Name cannot be null or empty");
        this.courseName = courseName;
    }
    //getter for startDate

    public LocalDate getStartDate() {
        return startDate;
    }
    //setter for startDate

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    //getter for weekDuration

    public int getWeekDuration() {
        return weekDuration;
    }
    //setter for weekDuration

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }
    //getter for student

    public List<Student> getStudents() {
        return students;
    }
    //method for managing students
    public void register(Student student){
        if (!students.contains(student)) {
            students.add(student);
        }
    }
    public void unregister(Student student){
        students.remove(student);
    }
}
