package com.walichin.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.walichin.controller.UserLogin;
import com.walichin.services.ValidateUserSpring;
import com.walichin.dataaccess.UserData;

@Component
public class ConvertValidateUser
{
	@Autowired
	ValidateUserSpring validateUserSpring;
	
	public Integer convertValidateUser(UserLogin userLogin) {
    	
		UserData userData = new UserData();
		
		userData.setLogin(userLogin.getLogin());
		userData.setPassword(userLogin.getPassword());
		
		Integer result = validateUserSpring.validateUser(userData);
		
		return result;
    }
}
