package com.walichin.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.walichin.controller.UserForm;
import com.walichin.services.SaveUserSpring;
import com.walichin.dataaccess.UserData;

@Component
public class ConvertNewUser
{
	@Autowired
	SaveUserSpring saveUserSpring;
	
	public boolean convertNewUser(UserForm userOrig) {
    	
		UserData userDest = new UserData();
		
		//userDest.setUser_id(userOrig.getUser_id());
		userDest.setName(userOrig.getName());
		userDest.setLogin(userOrig.getLogin());
		userDest.setPassword(userOrig.getPassword());
		userDest.setEmail(userOrig.getEmail());
		userDest.setIs_admin(userOrig.getIs_admin());
		userDest.setUrl_photo(userOrig.getUrl_photo());
		userDest.setGps_latitude(userOrig.getGps_latitude());
		userDest.setGps_longitude(userOrig.getGps_longitude());
		userDest.setGps_location(userOrig.getGps_location());		
		
		if (saveUserSpring.saveUser(userDest)) {
			return true;
		}
		return false;
    }
}
