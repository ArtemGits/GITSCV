package controllers.DAO.postgresql;

import controllers.model.User;
import controllers.DAO.interfaces.*;
import controllers.Hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.List;
import java.sql.SQLException;
import java.util.*;




public class PostgreUserDao implements UserDao {

	private User user;
	
	public PostgreUserDao() {
		  user = createUser();
	}
	
	@Override
	public User registerUser(User user) {
		Session session = Hibernate.openSession();
		session.beginTransaction();
		session.save(user);
		//session.save(item);
		
		setUserValid(true);
		session.getTransaction().commit();
		session.close();
		return user;
	}
	
	@Override
	public void setUserName(String name) {
		user.setName(name);
	}
	
	@Override
	public User authenticating(User user) {
		System.out.println("1");
		Session session = Hibernate.openSession();
		System.out.println("2");
		session.beginTransaction();
		System.out.println("3");
		String email=user.getEmail();
		System.out.println("4");
		String password=user.getPassword();
		System.out.println("5");
		String sql = "FROM User user where user.email = '"+email+"' AND user.password='"+password+"'";
		System.out.println(sql);
		
		Query query = (Query) session.createQuery(sql);
		System.out.println(query);
		
		for(Iterator it = query.iterate(); it.hasNext();) {
			System.out.println("QUERY!!!!!!!!!!!!!!!!!!!2");
			User u = (User)it.next();
			user.setEmail(u.getEmail());
			user.setPassword(u.getPassword());
			System.out.println("here 111111");
			user.setValid(true);
		}
		session.getTransaction().commit();
		session.close();
	//	System.out.println(email);
		return user;
	}
	
	@Override
	public void setUserEmail(String email) {
		user.setEmail(email);
	}
	
	@Override
	public void setUserPassword(String password) {
		user.setPassword(password);
	}
	@Override
	public void setUserValid(Boolean value) {
		user.setValid(value);
	}
	@Override 
	public Boolean UserIsValid() {
		return user.isValid();
	}
	@Override
	public User getUser() {
		return user;
	}
	
	private  User createUser() {
		return new User();
	}
	
	@Override
	public String getUserEmail(User user) {
		 return user.getEmail();
	}
	@Override
	public String getUserPassword(User user) {
		return user.getPassword();
	}
}
