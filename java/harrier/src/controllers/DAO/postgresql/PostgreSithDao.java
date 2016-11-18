package controllers.DAO.postgresql;

import controllers.Connections;
import controllers.Hibernate;
import controllers.DAO.interfaces.SithDao;
import controllers.model.Achievements;
import controllers.model.Siths;
import controllers.model.Status;
import controllers.model.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.*;



public class PostgreSithDao implements SithDao {

    private static final Logger logger = Logger.getLogger(PostgreSithDao.class);
    private Session session;
    
	

    
    @Override
    public List<Siths> getAll() {
       return getInstanceByName(null,0);
    }

   
    @SuppressWarnings("unchecked")
	@Override
    public List<Siths> getInstanceByName(String name, int status) {
       // String additional;
//        if(name == null) {
//            additional="";
//        } else {
//            additional = "and name_b = '"+ name +"' ";
//        }
//        if(status==1) {
//            additional+= "and status =1";
//        }
    	session = Hibernate.openSession();
        List<Siths> Siths = new ArrayList<>();

        
    	Query query = session.createQuery("select s from Siths s ");
		Siths = query.list();
		session.close();
        
                return Siths;
    }


	@Override
	public List<Siths> getInstanceByHome(String home) {
		logger.debug("getInstanceByName get list of Sith");
		List<Siths> Siths = new ArrayList<>();

		Connection conn;
		try {
			conn = PostgreDAOFactory.getConnection();
			conn.setAutoCommit(false);

			// Procedure call.
			CallableStatement proc = conn.prepareCall("{ ? = call sithsByHome(?) }");
			proc.registerOutParameter(1, Types.OTHER);
			proc.setString(2, home);
			proc.execute();
			System.out.println("Procedure motherfuckers!");
			ResultSet rs = (ResultSet) proc.getObject(1);
			while (rs.next()) {
                Siths.add(new Siths(rs.getInt("id"),
                		rs.getString("rang"),
                		rs.getInt("id_status"),
                        rs.getString("old_name"),
                        rs.getString("new_name"),
                        rs.getInt("age"),
                        rs.getString("home"),
                        rs.getBoolean("canon"),
                        rs.getBoolean("history")));
            }
			rs.close();
			proc.close();
			conn.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        //if no instances
        if(Siths.isEmpty()) {
            return new ArrayList<>();
        }

                return Siths;
	}


	@Override
	public List<Siths> getStudentsByTeacherName(String tname) {
		List<Siths> Siths = new ArrayList<>();

        logger.debug("getInstanceByName get list of Sith");
        Connection conn;
		try {
			conn = PostgreDAOFactory.getConnection();
			conn.setAutoCommit(false);

			// Procedure call.
			CallableStatement proc = conn.prepareCall("{ ? = call StudentByTeacherName(?) }");
			proc.registerOutParameter(1, Types.OTHER);
			proc.setString(2, tname);
			proc.execute();
			System.out.println("Procedure studentByTeacher motherfuckers!");
			ResultSet rs = (ResultSet) proc.getObject(1);
            while (rs.next()) {
                Siths.add(new Siths(rs.getInt("id"),
                		rs.getString("rang"),
                		rs.getInt("id_status"),
                        rs.getString("old_name"),
                        rs.getString("new_name"),
                        rs.getInt("age"),
                        rs.getString("home"),
                        rs.getBoolean("canon"),
                        rs.getBoolean("history")));
            }
            rs.close();
            proc.close();
            conn.close();
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
	public List<Siths> getTeacherByStudentName(String sname) {
		List<Siths> Siths = new ArrayList<>();

        logger.debug("getInstanceByName get list of Sith");

        
        Connection conn;
		try {
			conn = PostgreDAOFactory.getConnection();
			conn.setAutoCommit(false);

			// Procedure call.
			CallableStatement proc = conn.prepareCall("{ ? = call TeacherByStudentName(?) }");
			proc.registerOutParameter(1, Types.OTHER);
			proc.setString(2, sname);
			proc.execute();
			System.out.println("Procedure TeacherByStudentName motherfuckers!");
			ResultSet rs = (ResultSet) proc.getObject(1);
            while (rs.next()) {
                Siths.add(new Siths(rs.getInt("id"),
                		rs.getString("rang"),
                		rs.getInt("id_status"),
                        rs.getString("old_name"),
                        rs.getString("new_name"),
                        rs.getInt("age"),
                        rs.getString("home"),
                        rs.getBoolean("canon"),
                        rs.getBoolean("history")));
            }
            rs.close();
            proc.close();
            conn.close();
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
	public List<Siths> getSithsByRang(String rang) {
		List<Siths> Siths = new ArrayList<>();    
	
		logger.debug("getInstanceByName get list of Sith");
		Connection conn;
		try {
			conn = PostgreDAOFactory.getConnection();
			conn.setAutoCommit(false);

			// Procedure call.
			CallableStatement proc = conn.prepareCall("{ ? = call sithsByRang(?) }");
			proc.registerOutParameter(1, Types.OTHER);
			proc.setString(2, rang);
			proc.execute();
			System.out.println("Procedure rang motherfuckers!");
			ResultSet rs = (ResultSet) proc.getObject(1);
			while (rs.next()) {
                Siths.add(new Siths(rs.getInt("id"),
                		rs.getString("rang"),
                		rs.getInt("id_status"),
                        rs.getString("old_name"),
                        rs.getString("new_name"),
                        rs.getInt("age"),
                        rs.getString("home"),
                        rs.getBoolean("canon"),
                        rs.getBoolean("history")));
            }
			rs.close();
			proc.close();
			conn.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        //if no instances
        if(Siths.isEmpty()) {
            return new ArrayList<>();
        }

                return Siths;
	}


	@Override
	public List<Map<Status, List<Siths>>> getSithsByStatus(String status) {
		List<Map<Status, List<Siths>>> instances = new ArrayList<>();
		List<Status> statuses = new ArrayList<>();
		logger.debug("getInstanceByName get list of Sith");
		Connection conn;
		try {
			conn = PostgreDAOFactory.getConnection();
			conn.setAutoCommit(false);

			// Procedure call.
			CallableStatement proc = conn.prepareCall("{ ? = call ByStatus(?) }");
			proc.registerOutParameter(1, Types.OTHER);
			proc.setString(2, status);
			proc.execute();
			System.out.println("Procedure byStatus motherfuckers!");
			ResultSet rs = (ResultSet) proc.getObject(1);
            while (rs.next()) {
                statuses.add(new Status(rs.getInt("id"),
                		rs.getString("status")
                		));
            }
            rs.close();
			proc.close();
			conn.close();
        } catch (SQLException e) {
            logger.error("SQLException getInstacesByName", e);
        }
		
        if(statuses.isEmpty()) {
            return new ArrayList<>();
        }
        List<Siths> Siths = new ArrayList<>();

        logger.debug("getInstanceByName get list of Sith");
        try {
			conn = PostgreDAOFactory.getConnection();
			conn.setAutoCommit(false);

			// Procedure call.
			CallableStatement proc = conn.prepareCall("{ ? = call BySiths() }");
			proc.registerOutParameter(1, Types.OTHER);
			proc.execute();
			System.out.println("Procedure bySiths motherfuckers!");
			ResultSet rs = (ResultSet) proc.getObject(1);

            while (rs.next()) {
                Siths.add(new Siths(rs.getInt("id"),
                		rs.getString("rang"),
                		rs.getInt("id_status"),
                        rs.getString("old_name"),
                        rs.getString("new_name"),
                        rs.getInt("age"),
                        rs.getString("home"),
                        rs.getBoolean("canon"),
                        rs.getBoolean("history")));
            }
            rs.close();
			proc.close();
			conn.close();
        } catch (SQLException e) {
            logger.error("SQLException getInstacesByName", e);
        }
        //if no instances
        if(Siths.isEmpty()) {
            return new ArrayList<>();
        }
        
        Map<Status, List<Siths>> mapstatus;
        List<Siths> sith;
        for (Status st: statuses) {
            sith = new ArrayList<>();
            mapstatus = new HashMap<>();
            for (Siths s:Siths) {
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
	public List<Map<Siths, List<Achievements>>> getAchieveBySith(String aname) {
		List<Map<Siths, List<Achievements>>> instances = new ArrayList<>();
		
        List<Siths> Siths = new ArrayList<>();

        logger.debug("getInstanceByName get list of Sith");
        
        Connection conn;
		try {
			conn = PostgreDAOFactory.getConnection();
			conn.setAutoCommit(false);

			// Procedure call.
			CallableStatement proc = conn.prepareCall("{ ? = call SithByName(?) }");
			proc.registerOutParameter(1, Types.OTHER);
			proc.setString(2, aname);
			proc.execute();
			System.out.println("Procedure SithByName motherfuckers!");
			ResultSet rs = (ResultSet) proc.getObject(1);
            while (rs.next()) {
                Siths.add(new Siths(rs.getInt("id"),
                		rs.getString("rang"),
                		rs.getInt("id_status"),
                        rs.getString("old_name"),
                        rs.getString("new_name"),
                        rs.getInt("age"),
                        rs.getString("home"),
                        rs.getBoolean("canon"),
                        rs.getBoolean("history")));
            }
            rs.close();
			proc.close();
			conn.close();
        } catch (SQLException e) {
            logger.error("SQLException getInstacesByName", e);
        }
        
        //if no instances
        if(Siths.isEmpty()) {
            return new ArrayList<>();
        }
        List<Achievements> achieves = new ArrayList<>();
		logger.debug("getInstanceByName get list of Sith");
		try {
			conn = PostgreDAOFactory.getConnection();
			conn.setAutoCommit(false);

			// Procedure call.
			CallableStatement proc = conn.prepareCall("{ ? = call ByAchievements() }");
			proc.registerOutParameter(1, Types.OTHER);
			proc.execute();
			System.out.println("Procedure byAchievements motherfuckers!");
			ResultSet rs = (ResultSet) proc.getObject(1);
            while (rs.next()) {
                achieves.add(new Achievements(rs.getInt("id"),
                		rs.getInt("kills"),
                		rs.getInt("duels"),
                		rs.getInt("loses"),
                		rs.getInt("wins")
                		));
            }
            rs.close();
			proc.close();
			conn.close();
        } catch (SQLException e) {
            logger.error("SQLException getInstacesByName", e);
        }
        
        if(achieves.isEmpty()) {
        	
            return new ArrayList<>();
        }
       
        Map<Siths, List<Achievements>> mapachieves;
        List<Achievements> achiv;
        for (Siths s: Siths) {
            achiv = new ArrayList<>();
            mapachieves = new HashMap<>();
            for (Achievements a:achieves) {
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
	public List<Map<Siths, List<Achievements>>> getBestSithByStatus() {
		List<Map<Siths, List<Achievements>>> instances = new ArrayList<>();
		
        List<Siths> Siths = new ArrayList<>();

        logger.debug("getInstanceByName get list of Sith");
        Connection conn;
		try {
			conn = PostgreDAOFactory.getConnection();
			conn.setAutoCommit(false);

			// Procedure call.
			CallableStatement proc = conn.prepareCall("{ ? = call SithByAchievments() }");
			proc.registerOutParameter(1, Types.OTHER);
			proc.execute();
			System.out.println("Procedure SithByAchivments motherfuckers!");
			ResultSet rs = (ResultSet) proc.getObject(1);
            while (rs.next()) {
                Siths.add(new Siths(rs.getInt("id"),
                		rs.getString("rang"),
                		rs.getInt("id_status"),
                        rs.getString("old_name"),
                        rs.getString("new_name"),
                        rs.getInt("age"),
                        rs.getString("home"),
                        rs.getBoolean("canon"),
                        rs.getBoolean("history")));
            }           
            rs.close();
            proc.close();
            conn.close();
        } catch (SQLException e) {
            logger.error("SQLException getInstacesByName", e);
        }
        
        //if no instances
        if(Siths.isEmpty()) {
            return new ArrayList<>();
        }
        List<Achievements> achieves = new ArrayList<>();
		logger.debug("getInstanceByName get list of Sith");
		
		try {
			conn = PostgreDAOFactory.getConnection();
			conn.setAutoCommit(false);

			// Procedure call.
			CallableStatement proc = conn.prepareCall("{ ? = call ByAchievements() }");
			proc.registerOutParameter(1, Types.OTHER);
			proc.execute();
			System.out.println("Procedure byAchievements motherfuckers!");
			ResultSet rs = (ResultSet) proc.getObject(1);
            while (rs.next()) {
                achieves.add(new Achievements(rs.getInt("id"),
                		rs.getInt("kills"),
                		rs.getInt("duels"),
                		rs.getInt("loses"),
                		rs.getInt("wins")
                		));
            }
            rs.close();
			proc.close();
			conn.close();

        } catch (SQLException e) {
            logger.error("SQLException getInstacesByName", e);
        }
        
        if(achieves.isEmpty()) {
        	
            return new ArrayList<>();
        }
       
        Map<Siths, List<Achievements>> mapachieves;
        List<Achievements> achiv;
        for (Siths s: Siths) {
            achiv = new ArrayList<>();
            mapachieves = new HashMap<>();
            for (Achievements a:achieves) {
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
	public List<Siths> getAllFromCanone() {
		List<Siths> Siths = new ArrayList<>();
		Connection conn;
        logger.debug("getInstanceByName get list of Sith");
        try {
			conn = PostgreDAOFactory.getConnection();
			conn.setAutoCommit(false);

			// Procedure call.
			CallableStatement proc = conn.prepareCall("{ ? = call SithByCanone() }");
			proc.registerOutParameter(1, Types.OTHER);
			proc.execute();
			System.out.println("Procedure byCanone motherfuckers!");
			ResultSet rs = (ResultSet) proc.getObject(1);
            while (rs.next()) {
                Siths.add(new Siths(rs.getInt("id"),
                		rs.getString("rang"),
                		rs.getInt("id_status"),
                        rs.getString("old_name"),
                        rs.getString("new_name"),
                        rs.getInt("age"),
                        rs.getString("home"),
                        rs.getBoolean("canon"),
                        rs.getBoolean("history")));
            }
            rs.close();
            proc.close();
            conn.close();
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
	public List<Siths> getAllFromHistory() {
		List<Siths> Siths = new ArrayList<>();

        Connection conn;
        logger.debug("getInstanceByName get list of Sith");
        try {
			conn = PostgreDAOFactory.getConnection();
			conn.setAutoCommit(false);

			// Procedure call.
			CallableStatement proc = conn.prepareCall("{ ? = call SithByHistory() }");
			proc.registerOutParameter(1, Types.OTHER);
			proc.execute();
			System.out.println("Procedure byHistory motherfuckers!");
			ResultSet rs = (ResultSet) proc.getObject(1);
            while (rs.next()) {
                Siths.add(new Siths(rs.getInt("id"),
                		rs.getString("rang"),
                		rs.getInt("id_status"),
                        rs.getString("old_name"),
                        rs.getString("new_name"),
                        rs.getInt("age"),
                        rs.getString("home"),
                        rs.getBoolean("canon"),
                        rs.getBoolean("history")));
            }
            rs.close();
            proc.close();
            conn.close();

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
	public List<Siths> getAllforUsers() {
		List<Siths> siths = new ArrayList<>();

        
		Connection conn;
        logger.debug("getInstanceByName get list of Sith");
        try {
			conn = PostgreDAOFactory.getConnection();
			conn.setAutoCommit(false);

			// Procedure call.
			CallableStatement proc = conn.prepareCall("{ ? = call BySiths() }");
			proc.registerOutParameter(1, Types.OTHER);
			proc.execute();
			System.out.println("Procedure bySiths motherfuckers!");
			ResultSet rs = (ResultSet) proc.getObject(1);

        	 while (rs.next()) {
             	
        		 siths.add(new Siths(rs.getInt("id"),
                 		rs.getString("rang"),
                 		rs.getInt("id_status"),
                         rs.getString("old_name"),
                         rs.getString("new_name"),
                         rs.getInt("age"),
                         rs.getString("home"),
                         rs.getBoolean("canon"),
                         rs.getBoolean("history")));
             }
        	 rs.close();
             proc.close();
             conn.close();
        } catch (SQLException e) {
            logger.error("SQLException getInstacesByName", e);
        }
        //if no instances
        if(siths.isEmpty()) {
            return new ArrayList<>();
        }

                return siths;

	}


	@Override
	public Siths getSith(int id) {
		session = Hibernate.openSession();
		Siths sith = null;

        
		Query query = session.createQuery("select s from Siths s where id=:id ");
		query.setParameter("id",id);
		sith = (Siths) query.uniqueResult();
		session.close();
        return sith;

	}


	@Override
	public boolean updateSith(int id, String rang, int id_status, String old_name, String new_name, int age, String home,
			boolean canon, boolean history) {
		session = Hibernate.openSession();
		logger.debug("Update Siths");
		boolean flag = false;
		Transaction t = null;
		try {
		t = session.beginTransaction();
		Query query = session.createQuery("update Siths set rang=:rang,id_status=:id_status,old_name=:old_name,new_name=:new_name, age=:age,home=:home,canon=:canon, history=:history WHERE id=:id");
		query.setParameter("id", id);
		query.setParameter("rang", rang);
		query.setParameter("id_status", id_status);
		query.setParameter("old_name", old_name);
		query.setParameter("new_name", new_name);
		query.setParameter("age", age);
		query.setParameter("home", home);
		query.setParameter("canon", canon);
		query.setParameter("history", history);
		query.executeUpdate();
		t.commit();
		flag = true;
		} catch (HibernateException e) {
		e.printStackTrace();
		t.rollback();
		}
		session.close();
		return flag;
	}


	@Override
	public boolean createSith(Siths sith) {
		session = Hibernate.openSession();
		boolean flag = false;
		Transaction t = null;
		try {
		t = session.beginTransaction();
		session.saveOrUpdate(sith);
		t.commit();
		flag = true;
		} catch (HibernateException e) {
		e.printStackTrace();
		t.rollback();
		}
		session.close();
		return flag;
	}


	@Override
	public boolean deleteSith(int id) {
		session = Hibernate.openSession();
		boolean flag = false;
		Transaction t = null;
		try {
		t = session.beginTransaction();
		Query query = session.createQuery("delete Siths where id=:id");
		query.setParameter("id", id);
		 query.executeUpdate();
		t.commit();
		flag = true;
		} catch (HibernateException e) {
		e.printStackTrace();
		t.rollback();
		}
		session.close();
		return flag;
	}
	
	


	
}
