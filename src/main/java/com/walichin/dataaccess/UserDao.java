package com.walichin.dataaccess;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.DataAccessException;  
import org.springframework.jdbc.core.ResultSetExtractor;  

import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.ArrayList;  
import java.util.List;  

public class UserDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int saveUser(UserData e) {
		String query = "insert into adm_user_mt ("
				+ "name, login, password, email, is_admin, url_photo, gps_latitude, gps_longitude, gps_location) "
				+ "values('" + e.getName()
				+ "','" + e.getLogin()
				+ "','" + e.getPassword()
				+ "','" + e.getEmail()
				+ "','" + e.getIs_admin()
				+ "','" + e.getUrl_photo()
				+ "','" + e.getGps_latitude()
				+ "','" + e.getGps_longitude()
				+ "','" + e.getGps_location()
				+ "')";
		return jdbcTemplate.update(query);
	}

	public int updateUser(UserData e) {
		String query = "update adm_user_mt set "
				+ "name='" + e.getName()
				+ "',login='" + e.getLogin()
				+ "',password='" + e.getPassword() 
				+ "',email='" + e.getEmail() 
				+ "',is_admin='" + e.getIs_admin() 
				+ "',url_photo='" + e.getUrl_photo() 
				+ "',gps_latitude='" + e.getGps_latitude() 
				+ "',gps_longitude='" + e.getGps_longitude() 
				+ "',gps_location='" + e.getGps_location() 
				+ "' where user_id=" + e.getUser_id();
		return jdbcTemplate.update(query);
	}

	public int deleteUser(UserData e) {
		String query = "delete from adm_user_mt where user_id='" + e.getUser_id() + "' ";
		return jdbcTemplate.update(query);
	}

	public int validateUser(UserData e) {
		
		return jdbcTemplate.query("select count(*) from adm_user_mt where login='" + e.getLogin().trim() + "' and password='" + e.getPassword().trim() + "'", new ResultSetExtractor<Integer>() {
			
			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {

				rs.next();
				Integer result = rs.getInt(1);
				return result;
			}
		});
	}

	public List<UserData> getAllUsers() {
		
		return jdbcTemplate.query("select user_id, name, login, password, email, is_admin, url_photo, gps_latitude, "
				+ "gps_longitude, gps_location from adm_user_mt", new ResultSetExtractor<List<UserData>>() {
			
			@Override
			public List<UserData> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<UserData> list = new ArrayList<UserData>();
				
				while (rs.next()) {
					
					UserData e = new UserData();
					
					e.setUser_id(rs.getInt(1));
					e.setName(rs.getString(2));
					e.setLogin(rs.getString(3));
					e.setPassword(rs.getString(4));
					e.setEmail(rs.getString(5));
					e.setIs_admin(rs.getString(6));
					e.setUrl_photo(rs.getString(7));
					e.setGps_latitude(rs.getString(8));
					e.setGps_longitude(rs.getString(9));
					e.setGps_location(rs.getString(10));
					
					list.add(e);
				}
				return list;
			}
		});
	}

}
