package controllers.DAO.postgresql;

import controllers.Connections;
import controllers.Hibernate;
import controllers.DAO.interfaces.StatusDao;
import controllers.model.Achievements;
import controllers.model.Status;
import controllers.model.Teacher;

import java.util.ArrayList;
import java.util.List;


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



public class PostgreStatusDao implements StatusDao {

    private static final Logger logger = Logger.getLogger(PostgreStatusDao.class);
    private Session session;
   
    
	@SuppressWarnings("unchecked")
	@Override
	public List<Status> getAll() {
		session = Hibernate.openSession();
		List<Status> statuses = new ArrayList<>();
		Query query = session.createQuery("select s from Status s ");
		statuses = query.list();
		session.close();     
        return statuses;
	}

	@Override
	public Status getStatuses(int id) {
		session = Hibernate.openSession();
		Status status = null;

        
		Query query = session.createQuery("select s from Status s where id=:id ");
		query.setParameter("id",id);
		status = (Status) query.uniqueResult();
		session.close();

                return status;
	}

	@Override
	public boolean updateStatus(int id, String status) {
		session = Hibernate.openSession();
		boolean flag = false;
		Transaction t = null;
		try {
		t = session.beginTransaction();
		Query query = session.createQuery("update Status set status=:status WHERE id=:id");
		query.setParameter("id", id);
		query.setParameter("status", status);
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
	public boolean createStatus(Status status) {
		session = Hibernate.openSession(); 
		boolean flag = false;
		Transaction t = null;
		try {
		t = session.beginTransaction();
		session.saveOrUpdate(status);
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
	public boolean deleteStatus(int id) {
		session = Hibernate.openSession();
		boolean flag = false;
		Transaction t = null;
		try {
		t = session.beginTransaction();
		Query query = session.createQuery("delete Status where id=:id");
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
