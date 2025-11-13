package se.lexicon;

import java.util.List;

public interface CourseDao {

    public Course save(Course course);
    public Course findById(int id);
    public List<Course> findByName(String name);
    public List<Course> findByDate (String date);
    public List<Course> findAll();
    public boolean delete(int id);
}
