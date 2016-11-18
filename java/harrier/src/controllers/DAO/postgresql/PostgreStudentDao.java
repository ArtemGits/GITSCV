package controllers.DAO.postgresql;

import controllers.Connections;
import controllers.Hibernate;
import controllers.DAO.interfaces.StudentDao;
import controllers.model.Achievements;
import controllers.model.Student;

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



public class PostgreStudentDao implements StudentDao {

    private static final Logger logger = Logger.getLogger(PostgreStudentDao.class);
    private Session session;
    
    
    
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAll() {
		session = Hibernate.openSession();
		List<Student> students = new ArrayList<>();

        
		Query query = session.createQuery("select s from Student s ");
		students = query.list();
		
		session.close();
                return students;
	}

	@Override
	public Student getStudent(int id) {
		session = Hibernate.openSession();
		Student student = null;

		Query query = session.createQuery("select s from Student s where id=:id ");
		query.setParameter("id",id);
		student = (Student) query.uniqueResult();
		session.close();
        return student;
	}

	@Override
	public boolean updateStudent(int id ,int id_student, int id_teacher) {
		session = Hibernate.openSession();
		boolean flag = false;
		Transaction t = null;
		try {
		t = session.beginTransaction();
		Query query = session.createQuery("update Student set id_student=:id_student, id_teacher=:id_teacher WHERE id=:id");
		query.setParameter("id", id);
		query.setParameter("id_student", id_student);
		query.setParameter("id_teacher", id_teacher);
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
	public boolean createStudent(Student student) {
		session = Hibernate.openSession();
		boolean flag = false;
		Transaction t = null;
		try {
		t = session.beginTransaction();
		session.saveOrUpdate(student);
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
	public boolean deleteStudent(int id) {
		session = Hibernate.openSession();
		boolean flag = false;
		Transaction t = null;
		try {
		t = session.beginTransaction();
		Query query = session.createQuery("delete Student where id=:id");
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
