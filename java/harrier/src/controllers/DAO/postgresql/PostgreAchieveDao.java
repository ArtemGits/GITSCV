package controllers.DAO.postgresql;

import controllers.Connections;
import controllers.Hibernate;
import controllers.DAO.interfaces.AchieveDao;
import controllers.model.Achievements;
import controllers.model.Siths;

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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;



public class PostgreAchieveDao implements AchieveDao {

    private static final Logger logger = Logger.getLogger(PostgreAchieveDao.class);
    private Session session;
    
    
	@SuppressWarnings("unchecked")
	@Override
	public List<Achievements> getAll() {
		session = Hibernate.openSession();
		 List<Achievements> achieves = new ArrayList<>();

	        
		Query query = session.createQuery("select t from Achievements t ");
		achieves = query.list();
		session.close();
	                return achieves;
	    
	}

	@Override
	public Achievements getAchieve(int id) {
		session = Hibernate.openSession();
		Achievements achieve = null;

        
		Query query = session.createQuery("select t from Achievements t where id=:id ");
		query.setParameter("id",id);
		achieve = (Achievements) query.uniqueResult();
		session.close();
        

                return achieve;
	}

	@Override
	public boolean updateAchive(int id, int duels, int wins, int loses,int kills) {
		session = Hibernate.openSession();
		boolean flag = false;
		Transaction t = null;
		try {
		t = session.beginTransaction();
		Query query = session.createQuery("update Achievements set duels=:duels,wins=:wins,loses=:loses,kills=:kills WHERE id=:id");
		query.setParameter("id", id);
		query.setParameter("duels", duels);
		query.setParameter("wins", wins);
		query.setParameter("loses", loses);
		query.setParameter("kills", kills);
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
	public boolean createAchieve(Achievements achieve) {
		
		session = Hibernate.openSession();
		boolean flag = false;
		Transaction t = null;
		try {
		t = session.beginTransaction();
		session.saveOrUpdate(achieve);
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
	public boolean deleteAchieve(int id) {
		session = Hibernate.openSession();
		boolean flag = false;
		Transaction t = null;
		try {
		t = session.beginTransaction();
		Query query = session.createQuery("delete Achievements where id=:id");
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
