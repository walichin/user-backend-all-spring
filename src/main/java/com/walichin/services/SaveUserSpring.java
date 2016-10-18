package com.walichin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.walichin.dataaccess.UserDao;
import com.walichin.dataaccess.UserData;

@Component
public class SaveUserSpring {
	
	@Autowired
	UserDao userDao;
	
    public boolean saveUser(UserData userData) {
    	
		int status = userDao.saveUser(userData);
		System.out.println("Resultado (userDao.saveUser): " + status);
        return true;
    }
}
