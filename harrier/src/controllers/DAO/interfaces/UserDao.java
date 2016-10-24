package controllers.DAO.interfaces;

import controllers.model.*;
public interface UserDao {
	//some func to user
	User getUser();
	
	void setUserEmail(String email);
	void setUserPassword(String password);
	void setUserValid(Boolean value);
	Boolean UserIsValid();
	User registerUser(User user);
	User authenticating(User user);
	String getUserPassword(User user);
	String getUserEmail(User user);
	void setUserName(String name);
	
	
	
}
