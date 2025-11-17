package se.lexicon;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    public static List<Student> students = new ArrayList<>();


    @Override
    public Student saveStudent(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public Student findByEmail(String email) {
        for (Student s : students) {
            if (s.getEmail().equalsIgnoreCase(email)) return s;
        }
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) result.add(s);
        }
        return result;
    }

    @Override
    public Student findById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public boolean delete(Student student) {
        return students.remove(student);
    }

}
