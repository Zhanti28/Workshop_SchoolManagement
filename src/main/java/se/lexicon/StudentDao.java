package se.lexicon;

import java.util.List;

public interface StudentDao {

    public Student save(Student student);
    public Student findByEmail(String email);
    public List<Student> findByName(String name);
    public Student findById(int id);
    public List<Student> findAll();
    public boolean delete(Student student);

}
