package controllers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import controllers.DAO.interfaces.*;

import controllers.DAO.postgresql.PostgreDAOFactory;

public class Connections {
	private static DaoFactory factory = null;
	
	final private static String driverName = "org.postgresql.Driver";
    final private static String username = "gits";
    final private static String password = "gits2016";
    final private static String url= "jdbc:postgresql://localhost:5432/harrier";
    final private static Logger logger = Logger.getLogger(PostgreDAOFactory.class);


	public Connections() {
		
	}
	
	public Connection getConnection() throws SQLException {
		//Locale.setDefault(Locale.ENGLISH);
        try {
            Class.forName(driverName).newInstance();
        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
            logger.error("Exception in getConnection",e);
            e.printStackTrace();
        }
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
	}
	
	public static DaoFactory getFactory() {
		if(factory == null) {
			factory = new PostgreDAOFactory();
		}
		return factory;
	}
	
}
