package controllers.DAO.postgresql;

import controllers.Connections;

import controllers.DAO.interfaces.SithDao;
import controllers.model.Achieve;
import controllers.model.Sith;
import controllers.model.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;



public class PostgreSithDao implements SithDao {

    private static final Logger logger = Logger.getLogger(PostgreSithDao.class);

	

    
    @Override
    public List<Sith> getAll() {
       return getInstanceByName(null,0);
    }

   
    @Override
    public List<Sith> getInstanceByName(String name, int status) {
       // String additional;
//        if(name == null) {
//            additional="";
//        } else {
//            additional = "and name_b = '"+ name +"' ";
//        }
//        if(status==1) {
//            additional+= "and status =1";
//        }

        List<Sith> Siths = new ArrayList<>();

        logger.debug("getInstanceByName get list of Sith");
        try(final Connection connection = PostgreDAOFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(
                    "SELECT * from siths")) {
            while (rs.next()) {
                Siths.add(new Sith(rs.getInt("id"),
                		rs.getString("rang"),
                		rs.getInt("id_status"),
                        rs.getString("old_name"),
                        rs.getString("new_name"),
                        rs.getInt("age"),
                        rs.getString("home"),
                        rs.getBoolean("canon"),
                        rs.getBoolean("history")));
            }
        } catch (SQLException e) {
            logger.error("SQLException getInstacesByName", e);
        }
        //if no instances
        if(Siths.isEmpty()) {
            return new ArrayList<>();
        }

                return Siths;
    }


	@Override
	public List<Sith> getInstanceByHome(String home) {
		List<Sith> Siths = new ArrayList<>();

        logger.debug("getInstanceByName get list of Sith");
        try(final Connection connection = PostgreDAOFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(
                    "SELECT * from siths where home like'" + home + "'")) {
            while (rs.next()) {
                Siths.add(new Sith(rs.getInt("id"),
                		rs.getString("rang"),
                		rs.getInt("id_status"),
                        rs.getString("old_name"),
                        rs.getString("new_name"),
                        rs.getInt("age"),
                        rs.getString("home"),
                        rs.getBoolean("canon"),
                        rs.getBoolean("history")));
            }
        } catch (SQLException e) {
            logger.error("SQLException getInstacesByName", e);
        }
        //if no instances
        if(Siths.isEmpty()) {
            return new ArrayList<>();
        }

                return Siths;
	}


	@Override
	public List<Sith> getStudentsByTeacherName(String tname) {
		List<Sith> Siths = new ArrayList<>();

        logger.debug("getInstanceByName get list of Sith");
        try(final Connection connection = PostgreDAOFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(
                    "select * from siths s join student st on s.id = st.id_student where st.id_teacher = "
                    + "(select s.id from siths   s  join teacher  t on s.id = t.id "
                    + "where s.new_name='" +tname+ "')"
                    )) {
            while (rs.next()) {
                Siths.add(new Sith(rs.getInt("id"),
                		rs.getString("rang"),
                		rs.getInt("id_status"),
                        rs.getString("old_name"),
                        rs.getString("new_name"),
                        rs.getInt("age"),
                        rs.getString("home"),
                        rs.getBoolean("canon"),
                        rs.getBoolean("history")));
            }
        } catch (SQLException e) {
            logger.error("SQLException getInstacesByName", e);
        }
        //if no instances
        if(Siths.isEmpty()) {
            return new ArrayList<>();
        }

                return Siths;
	}


	@Override
	public List<Sith> getTeacherByStudentName(String sname) {
		List<Sith> Siths = new ArrayList<>();

        logger.debug("getInstanceByName get list of Sith");
        try(final Connection connection = PostgreDAOFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(
                    "select s.id,s.old_name,s.new_name, s.rang, s.home, s.age,s.id_status,s.canon,s.history from siths s where s.id = "
                    + "(select st.id_teacher from student st join siths s on st.id_student = s.id  where s.new_name ='"+ sname + "')"
                    )) {
            while (rs.next()) {
                Siths.add(new Sith(rs.getInt("id"),
                		rs.getString("rang"),
                		rs.getInt("id_status"),
                        rs.getString("old_name"),
                        rs.getString("new_name"),
                        rs.getInt("age"),
                        rs.getString("home"),
                        rs.getBoolean("canon"),
                        rs.getBoolean("history")));
            }
        } catch (SQLException e) {
            logger.error("SQLException getInstacesByName", e);
        }
        //if no instances
        if(Siths.isEmpty()) {
            return new ArrayList<>();
        }

                return Siths;
	}


	@Override
	public List<Sith> getSithsByRang(String rang) {
		List<Sith> Siths = new ArrayList<>();

        logger.debug("getInstanceByName get list of Sith");
        try(final Connection connection = PostgreDAOFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(
                    "select s.id,s.old_name,s.new_name, s.rang, s.home, s.age,s.id_status,s.canon,s.history from siths s where s.rang"
                    + "= '" + rang +"'"
                   
                    )) {
            while (rs.next()) {
                Siths.add(new Sith(rs.getInt("id"),
                		rs.getString("rang"),
                		rs.getInt("id_status"),
                        rs.getString("old_name"),
                        rs.getString("new_name"),
                        rs.getInt("age"),
                        rs.getString("home"),
                        rs.getBoolean("canon"),
                        rs.getBoolean("history")));
            }
        } catch (SQLException e) {
            logger.error("SQLException getInstacesByName", e);
        }
        //if no instances
        if(Siths.isEmpty()) {
            return new ArrayList<>();
        }

                return Siths;
	}


	@Override
	public List<Map<Status, List<Sith>>> getSithsByStatus(String status) {
		List<Map<Status, List<Sith>>> instances = new ArrayList<>();
		List<Status> statuses = new ArrayList<>();
		logger.debug("getInstanceByName get list of Sith");
        try(final Connection connection = PostgreDAOFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(
                    "select * from status where status = '" + status + "'"
                   
                    )) {
            while (rs.next()) {
                statuses.add(new Status(rs.getInt("id"),
                		rs.getString("status")
                		));
            }
        } catch (SQLException e) {
            logger.error("SQLException getInstacesByName", e);
        }
		
        if(statuses.isEmpty()) {
            return new ArrayList<>();
        }
        List<Sith> Siths = new ArrayList<>();

        logger.debug("getInstanceByName get list of Sith");
        try(final Connection connection = PostgreDAOFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(
                    "select * from siths"
                   
                    )) {
            while (rs.next()) {
                Siths.add(new Sith(rs.getInt("id"),
                		rs.getString("rang"),
                		rs.getInt("id_status"),
                        rs.getString("old_name"),
                        rs.getString("new_name"),
                        rs.getInt("age"),
                        rs.getString("home"),
                        rs.getBoolean("canon"),
                        rs.getBoolean("history")));
            }
        } catch (SQLException e) {
            logger.error("SQLException getInstacesByName", e);
        }
        //if no instances
        if(Siths.isEmpty()) {
            return new ArrayList<>();
        }
        
        Map<Status, List<Sith>> mapstatus;
        List<Sith> sith;
        for (Status st: statuses) {
            sith = new ArrayList<>();
            mapstatus = new HashMap<>();
            for (Sith s:Siths) {
                if(st.getId()==s.getId_status()) {
                    sith.add(s);
                }
            }
            mapstatus.put(st,sith);
            instances.add(mapstatus);
        }
        return instances;


	}


	@Override
	public List<Map<Sith, List<Achieve>>> getAchieveBySith(String aname) {
		List<Map<Sith, List<Achieve>>> instances = new ArrayList<>();
		
        List<Sith> Siths = new ArrayList<>();

        logger.debug("getInstanceByName get list of Sith");
        try(final Connection connection = PostgreDAOFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(
                    "select * from siths where new_name='" + aname + "'"
                   
                    )) {
            while (rs.next()) {
                Siths.add(new Sith(rs.getInt("id"),
                		rs.getString("rang"),
                		rs.getInt("id_status"),
                        rs.getString("old_name"),
                        rs.getString("new_name"),
                        rs.getInt("age"),
                        rs.getString("home"),
                        rs.getBoolean("canon"),
                        rs.getBoolean("history")));
            }
        } catch (SQLException e) {
            logger.error("SQLException getInstacesByName", e);
        }
        
        //if no instances
        if(Siths.isEmpty()) {
            return new ArrayList<>();
        }
        List<Achieve> achieves = new ArrayList<>();
		logger.debug("getInstanceByName get list of Sith");
        try(final Connection connection = PostgreDAOFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(
                    "select * from achievements" 
                   
                    )) {
            while (rs.next()) {
            	System.out.println("here am i");
                achieves.add(new Achieve(rs.getInt("id"),
                		rs.getInt("kills"),
                		rs.getInt("duels"),
                		rs.getInt("loses"),
                		rs.getInt("wins")
                		));
            }
        } catch (SQLException e) {
            logger.error("SQLException getInstacesByName", e);
        }
        
        if(achieves.isEmpty()) {
        	
            return new ArrayList<>();
        }
       
        Map<Sith, List<Achieve>> mapachieves;
        List<Achieve> achiv;
        for (Sith s: Siths) {
            achiv = new ArrayList<>();
            mapachieves = new HashMap<>();
            for (Achieve a:achieves) {
                if(s.getId()==a.getId()) {
                    achiv.add(a);
                }
            }
            mapachieves.put(s,achiv);
            instances.add(mapachieves);
        }
        
        return instances;
        

	}


	@Override
	public List<Map<Sith, List<Achieve>>> getBestSithByStatus() {
		List<Map<Sith, List<Achieve>>> instances = new ArrayList<>();
		
        List<Sith> Siths = new ArrayList<>();

        logger.debug("getInstanceByName get list of Sith");
        try(final Connection connection = PostgreDAOFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(
            		"select * from siths where id="
            		+ "(select s.id from siths s join achievements a on s.id = a.id group by s.id order by sum(a.kills + a.wins)  desc  limit 1)"

                   
                    )) {
            while (rs.next()) {
                Siths.add(new Sith(rs.getInt("id"),
                		rs.getString("rang"),
                		rs.getInt("id_status"),
                        rs.getString("old_name"),
                        rs.getString("new_name"),
                        rs.getInt("age"),
                        rs.getString("home"),
                        rs.getBoolean("canon"),
                        rs.getBoolean("history")));
            }
        } catch (SQLException e) {
            logger.error("SQLException getInstacesByName", e);
        }
        
        //if no instances
        if(Siths.isEmpty()) {
            return new ArrayList<>();
        }
        List<Achieve> achieves = new ArrayList<>();
		logger.debug("getInstanceByName get list of Sith");
        try(final Connection connection = PostgreDAOFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(
                    "select * from achievements" 
                   
                    )) {
            while (rs.next()) {
            	System.out.println("here am i");
                achieves.add(new Achieve(rs.getInt("id"),
                		rs.getInt("kills"),
                		rs.getInt("duels"),
                		rs.getInt("loses"),
                		rs.getInt("wins")
                		));
            }
        } catch (SQLException e) {
            logger.error("SQLException getInstacesByName", e);
        }
        
        if(achieves.isEmpty()) {
        	
            return new ArrayList<>();
        }
       
        Map<Sith, List<Achieve>> mapachieves;
        List<Achieve> achiv;
        for (Sith s: Siths) {
            achiv = new ArrayList<>();
            mapachieves = new HashMap<>();
            for (Achieve a:achieves) {
                if(s.getId()==a.getId()) {
                    achiv.add(a);
                }
            }
            mapachieves.put(s,achiv);
            instances.add(mapachieves);
        }
        
        return instances;

	}


	@Override
	public List<Sith> getAllFromCanone() {
		List<Sith> Siths = new ArrayList<>();

        logger.debug("getInstanceByName get list of Sith");
        try(final Connection connection = PostgreDAOFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(
                    "SELECT * from siths where canon='true'")) {
            while (rs.next()) {
                Siths.add(new Sith(rs.getInt("id"),
                		rs.getString("rang"),
                		rs.getInt("id_status"),
                        rs.getString("old_name"),
                        rs.getString("new_name"),
                        rs.getInt("age"),
                        rs.getString("home"),
                        rs.getBoolean("canon"),
                        rs.getBoolean("history")));
            }
        } catch (SQLException e) {
            logger.error("SQLException getInstacesByName", e);
        }
        //if no instances
        if(Siths.isEmpty()) {
            return new ArrayList<>();
        }

                return Siths;

	}


	@Override
	public List<Sith> getAllFromHistory() {
		List<Sith> Siths = new ArrayList<>();

        logger.debug("getInstanceByName get list of Sith");
        try(final Connection connection = PostgreDAOFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(
                    "SELECT * from siths where history='true'")) {
            while (rs.next()) {
                Siths.add(new Sith(rs.getInt("id"),
                		rs.getString("rang"),
                		rs.getInt("id_status"),
                        rs.getString("old_name"),
                        rs.getString("new_name"),
                        rs.getInt("age"),
                        rs.getString("home"),
                        rs.getBoolean("canon"),
                        rs.getBoolean("history")));
            }
        } catch (SQLException e) {
            logger.error("SQLException getInstacesByName", e);
        }
        //if no instances
        if(Siths.isEmpty()) {
            return new ArrayList<>();
        }

                return Siths;
	}
	


	
}
