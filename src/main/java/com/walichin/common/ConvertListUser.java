package com.walichin.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.walichin.controller.UserForm;
import com.walichin.services.ListUsersSpring;
import com.walichin.dataaccess.UserData;

@Component
public class ConvertListUser
{
	@Autowired
	ListUsersSpring listUsersSpring;
	
	public List<UserForm> convertListUser() {
    	
		List<UserForm> listUserForm = new ArrayList<UserForm>();
		List<UserData> listUserData = new ArrayList<UserData>();
		
		listUserData = listUsersSpring.listUsers();
		
		for(UserData userData:listUserData) {
			
			UserForm userForm = new UserForm();
			
			userForm.setUser_id(userData.getUser_id());
			userForm.setName(userData.getName());
			userForm.setLogin(userData.getLogin());
			userForm.setPassword(userData.getPassword());
			userForm.setEmail(userData.getEmail());
			userForm.setIs_admin(userData.getIs_admin());
			userForm.setUrl_photo(userData.getUrl_photo());
			userForm.setGps_latitude(userData.getGps_latitude());
			userForm.setGps_longitude(userData.getGps_longitude());
			userForm.setGps_location(userData.getGps_location());
			
			listUserForm.add(userForm);
			
		}
		
		return listUserForm;
    }
}
