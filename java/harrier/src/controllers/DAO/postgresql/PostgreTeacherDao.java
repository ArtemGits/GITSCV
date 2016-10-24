package controllers.DAO.postgresql;

import controllers.Connections;
import controllers.DAO.interfaces.TeacherDao;

import controllers.model.Sith;

import controllers.model.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * Created by igor on 21.04.16.
 */

/**
 * Class for working with DB table Instance
 * @author igor
 */

public class PostgreTeacherDao implements TeacherDao {

    private static final Logger logger = Logger.getLogger(PostgreTeacherDao.class);

	

    /**
     * Return list of instances with authors
     * @return list of instances
     */
    @Override
    public List<Teacher> getAll() {
        return getInstanceByName(null,0);
    }

    /**
     * Get Instance by name of book
     * @param name book name
     * @param status book status=1 if exist in library, else 0
     * @return list of instances
     */
    @Override
    public List<Teacher> getInstanceByName(String name, int status) {
        String additional;
//        if(name == null) {
//            additional="";
//        } else {
//            additional = "and name_b = '"+ name +"' ";
//        }
//        if(status==1) {
//            additional+= "and status =1";
//        }

        List<Teacher> teachers = new ArrayList<>();

        
        logger.debug("getInstanceByName get list of teacher");
        try(final Connection connection = PostgreDAOFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(
                    "SELECT * from teacher")) {
            while (rs.next()) {
                teachers.add(new Teacher(rs.getInt("id"),
                        rs.getString("old_name"),
                        rs.getString("new_name"),
                        rs.getString("home")));
            }
        } catch (SQLException e) {
            logger.error("SQLException getInstacesByName", e);
        }
        //if no instances
        if(teachers.isEmpty()) {
            return new ArrayList<>();
        }

                return teachers;
    }


	
}
