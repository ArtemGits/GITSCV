package controllers.DAO.interfaces;




import controllers.model.Teacher;

import java.util.List;




public interface TeacherDao {
    
	public List<Teacher > getAll();
    public Teacher getTeacher(int id);
    public boolean updateTeacher(int id, int stage);
    public boolean createTeacher(Teacher teacher);
    public boolean deleteTeacher(int id); 

}
