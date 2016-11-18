package services;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.List;
import java.sql.SQLException;
import java.util.*;
import controller.User;
import hibernate.Hibernate;
import items.Items;

public class LoginService {
	public User authenticating(User user) {
		Session session = Hibernate.openSession();
		session.beginTransaction();
		String email=user.getEmail();
		String password=user.getPassword();
		String sql = "FROM User user where user.email = '"+email+"' AND user.password='"+password+"'";
		System.out.println(sql);
		Query query = (Query) session.createQuery(sql);
		for(Iterator it = query.iterate(); it.hasNext();) {
			User u = (User)it.next();
			user.setEmail(u.getEmail());
			user.setPassword(u.getPassword());
			
			user.setValid(true);
		}
		session.getTransaction().commit();
		session.close();

		return user;
	}

	public User registerUser(User user, Items item) throws ClassNotFoundException, SQLException {
		Session session = Hibernate.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(item);
		user.setItem(item);
		user.setValid(true);
		session.getTransaction().commit();
		session.close();
		return user;
	}
}