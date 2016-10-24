package controllers.DAO.interfaces;



import controllers.model.Achieve;
import controllers.model.Sith;
import controllers.model.Status;

import java.util.List;
import java.util.Map;




public interface SithDao {
    /**
     * Return list of instances with authors
     * @return list of instances
     */
    public List<Sith > getAll();
    public List<Sith > getAllFromCanone();
    public List<Sith > getAllFromHistory();
    public List<Sith> getInstanceByHome(String home); 
    public List<Sith> getStudentsByTeacherName(String tname); 
    public List<Sith> getSithsByRang(String rang); 
    public List<Sith> getTeacherByStudentName(String sname); 
    public List<Sith> getInstanceByName(String name, int status);
    public List<Map<Status,List<Sith>>> getSithsByStatus(String status);
    public List<Map<Sith,List<Achieve>>> getAchieveBySith(String aname);
    public List<Map<Sith,List<Achieve>>> getBestSithByStatus();

}
