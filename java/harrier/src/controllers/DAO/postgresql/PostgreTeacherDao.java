package controllers.DAO.postgresql;


import controllers.Hibernate;
import controllers.DAO.interfaces.TeacherDao;


import controllers.model.Teacher;

import java.util.ArrayList;
import java.util.List;


import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;




 

public class PostgreTeacherDao implements TeacherDao {

    private static final Logger logger = Logger.getLogger(PostgreTeacherDao.class);
    private Session session;
   
	

   
    @SuppressWarnings("unchecked")
	@Override
    public List<Teacher> getAll() {
    	session = Hibernate.openSession();
    	List<Teacher> teachers = new ArrayList<>();
    	Query query = session.createQuery("select t from Teacher t ");
		teachers = query.list();
		session.close();
        
        
       return teachers;

    }




	@Override
	public Teacher getTeacher(int id) {
		session = Hibernate.openSession();
		Teacher teacher = null;

		Query query = session.createQuery("select t from Teacher t where id=:id ");
		query.setParameter("id",id);
		teacher = (Teacher) query.uniqueResult();
		session.close();
        
                return teacher;
	}




	@Override
	public boolean updateTeacher(int id, int sith_id) {
		session = Hibernate.openSession();
		boolean flag = false;
		Transaction t = null;
		try {
		t = session.beginTransaction();
		Query query = session.createQuery("update Teacher set sith_id=:sith_id WHERE id=:id");
		query.setParameter("id", id);
		query.setParameter("sith_id", sith_id);
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
	public boolean createTeacher(Teacher teacher) {
		session = Hibernate.openSession(); 
		boolean flag = false;
		Transaction t = null;
		try {
		t = session.beginTransaction();
		session.saveOrUpdate(teacher);
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
	public boolean deleteTeacher(int id) {
		session = Hibernate.openSession();
		boolean flag = false;
		Transaction t = null;
		try {
		t = session.beginTransaction();
		Query query = session.createQuery("delete Teacher where id=:id");
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
