package controllers.DAO.interfaces;



import controllers.model.Student;

import java.util.List;





public interface StudentDao {
    public List<Student > getAll();
    public Student getStudent(int id);
    public boolean updateStudent(int id, int id_student, int id_teacher);
    public boolean createStudent(Student student);
    public boolean deleteStudent(int id);
}
