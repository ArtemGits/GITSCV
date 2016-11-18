package controllers.DAO.postgresql;


import java.sql.Connection;
import java.sql.SQLException;

import controllers.Connections;
import controllers.Hibernate;
import controllers.DAO.interfaces.*;
import controllers.DAO.postgresql.*;
public class PostgreDAOFactory  implements DaoFactory {

	public static Connection getConnection() throws SQLException  {
 		
		return new Connections().getConnection();
		
 	}
 	@Override
 	public UserDao getUserDao() {
 		return new PostgreUserDao();
 	}
 	@Override
    public TeacherDao getTeacherDao() { 
 		return new PostgreTeacherDao(); 
 		
 	}
	@Override
	public SithDao getSithDao() {
		return new PostgreSithDao();
	}
	@Override
	public AchieveDao getAchieveDao() {
		return new PostgreAchieveDao();
	}
	@Override
	public StatusDao getStatusDao() {
		return new PostgreStatusDao();
	}
	@Override
	public StudentDao getStudentDao() {
		return new PostgreStudentDao();
	}
}
