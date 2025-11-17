package se.lexicon;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Course {
    private int id;
    private String courseName;
    private LocalDate date;
    private int weekDuration;
    List<Student> students = new ArrayList<>();



    //Constructor
    public Course(int id, String courseName, LocalDate date, int weekDuration) {
        setId(id);
        setCourseName(courseName);
        setDate(date);
        setWeekDuration(weekDuration);
    }


    //Setter and Getters
    //Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id !=0){
            this.id = id;
        }
    }


    //Course Name
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        if(courseName != null){
            this.courseName = courseName;
        }
    }

    //Date
    public LocalDate getDate() {
        return date;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }


    //Week Duration
    public int getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(int weekDuration) {
        if(weekDuration != 0){
            this.weekDuration = weekDuration;
        }
    }


    //Add and remove from the list
    public void addStudent(Student student){
        students.add(student);
    }

    public void removeStudent(Student student){
        students.remove(student);
    }


    @Override
    public String toString() {
        return "Course Id: " + id + ", Name: " + courseName + ", Date: " + date + ", Duration in week: " + weekDuration;
    }
}
