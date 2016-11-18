package controllers.DAO.interfaces;



import controllers.model.Achievements;

import java.util.List;





public interface AchieveDao {
    /**
     * Return list of instances with authors
     * @return list of instances
     */
    public List<Achievements > getAll();
    public Achievements getAchieve(int id);
    public boolean updateAchive(int id,int duels,int wins,int loses,int kills);
    public boolean createAchieve(Achievements achieve);
    public boolean deleteAchieve(int id);
}
