package com.walichin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import org.apache.log4j.Logger;

import com.walichin.dataaccess.UserDao;
import com.walichin.dataaccess.UserData;

@Component
public class ListUsersSpring {
	
	private static final Logger logger = Logger.getLogger(ListUsersSpring.class);
	
	@Autowired
	UserDao userDao;
	
	public List<UserData> listUsers() {
    	
	    List<UserData> list = userDao.getAllUsers();  
	    for(UserData e:list)  
	        
	    	logger.info("name: "+e.getName()+" login: "+e.getLogin()+" password: "+e.getPassword());
	    	//System.out.println("name: "+e.getName()+" login: "+e.getLogin()+" password: "+e.getPassword());
	    
	    return list;
	    
	}
}
