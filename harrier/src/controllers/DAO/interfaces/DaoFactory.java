package controllers.DAO.interfaces;

public interface DaoFactory {
	UserDao getUserDao();
	TeacherDao	getTeacherDao();
	SithDao getSithDao();
}
