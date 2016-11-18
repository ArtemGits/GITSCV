package controllers.DAO.interfaces;



import controllers.model.Achievements;
import controllers.model.Siths;
import controllers.model.Status;

import java.util.List;
import java.util.Map;




public interface SithDao {
    /**
     * Return list of instances with authors
     * @return list of instances
     */
    public List<Siths > getAll();
    public List<Siths > getAllFromCanone();
    public List<Siths > getAllFromHistory();
    public List<Siths> getInstanceByHome(String home); 
    public List<Siths> getStudentsByTeacherName(String tname); 
    public List<Siths> getSithsByRang(String rang); 
    public List<Siths> getTeacherByStudentName(String sname); 
    public List<Siths> getInstanceByName(String name, int status);
    public List<Map<Status,List<Siths>>> getSithsByStatus(String status);
    public List<Map<Siths,List<Achievements>>> getAchieveBySith(String aname);
    public List<Map<Siths,List<Achievements>>> getBestSithByStatus();
    
    
    public List<Siths> getAllforUsers();
    public Siths getSith(int id);
    public boolean updateSith(int id,String rang, int id_status, String old_name, String new_name, int age, String home, boolean canon, boolean history);
    public boolean createSith(Siths sith);
    public boolean deleteSith(int id);
     
}
