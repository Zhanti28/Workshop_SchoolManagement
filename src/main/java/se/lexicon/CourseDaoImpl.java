package se.lexicon;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

    public static List<Course> courses = new ArrayList<Course>();

    @Override
    public Course saveCourse(Course course) {
        courses.add(course);
        return course;
    }

    @Override
    public Course findById(int id) {
        for (Course c : courses) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    @Override
    public List<Course> findByName(String name) {
        List<Course> result = new ArrayList<>();
        for (Course c : courses) {
            if (c.getCourseName().equalsIgnoreCase(name)) result.add(c);
        }
        return result;
    }

    @Override
    public List<Course> findByDate (String date) {
        List<Course> result = new ArrayList<>();
        for (Course c : courses) {
            if (c.getDate().equals(date)) result.add(c);
        }
        return result;
    }

    @Override
    public List<Course> findAll() {
        return new ArrayList<>(courses);
    }

    @Override
    public boolean removeCourse(Course course) {
        return courses.remove(course);
    }

}
