package controllers.DAO.interfaces;



import controllers.model.Teacher;

import java.util.List;




public interface TeacherDao {
    /**
     * Return list of instances with authors
     * @return list of instances
     */
    List<Teacher > getAll();
    public List<Teacher> getInstanceByName(String name, int status); 

}
