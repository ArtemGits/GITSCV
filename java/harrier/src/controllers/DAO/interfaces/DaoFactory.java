package controllers.DAO.interfaces;

public interface DaoFactory {
	UserDao getUserDao();
	TeacherDao	getTeacherDao();
	SithDao getSithDao();
	AchieveDao getAchieveDao();
	StatusDao getStatusDao();
	StudentDao getStudentDao();
}
