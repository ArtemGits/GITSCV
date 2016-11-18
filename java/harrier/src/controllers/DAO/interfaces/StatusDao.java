package controllers.DAO.interfaces;



import controllers.model.Status;

import java.util.List;





public interface StatusDao {
    /**
     * Return list of instances with authors
     * @return list of instances
     */
    public List<Status > getAll();
    public Status getStatuses(int id);
    public boolean updateStatus(int id,String status);
    public boolean createStatus(Status status);
    public boolean deleteStatus(int id);
}
