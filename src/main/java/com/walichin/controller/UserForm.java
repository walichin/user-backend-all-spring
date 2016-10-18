package com.walichin.controller;

public class UserForm implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer user_id;
	private String name;
	private String login;
	private String password;
	private String email;
	private String is_admin;
	private String url_photo;
	private String gps_latitude;
	private String gps_longitude;
	private String gps_location;
	private String format;
	
	public UserForm() {
	}

//	public UserForm(String name, String login, String password, String format) {
//		this.name = name;
//		this.login = login;
//		this.password = password;
//		this.format = format;
//	}
	
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIs_admin() {
		return is_admin;
	}

	public void setIs_admin(String is_admin) {
		this.is_admin = is_admin;
	}

	public String getUrl_photo() {
		return url_photo;
	}

	public void setUrl_photo(String url_photo) {
		this.url_photo = url_photo;
	}

	public String getGps_latitude() {
		return gps_latitude;
	}

	public void setGps_latitude(String gps_latitude) {
		this.gps_latitude = gps_latitude;
	}

	public String getGps_longitude() {
		return gps_longitude;
	}

	public void setGps_longitude(String gps_longitude) {
		this.gps_longitude = gps_longitude;
	}

	public String getGps_location() {
		return gps_location;
	}

	public void setGps_location(String gps_location) {
		this.gps_location = gps_location;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

}
