package com.walichin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.apache.log4j.Logger;

import com.walichin.dataaccess.UserDao;
import com.walichin.dataaccess.UserData;

@Component
public class ValidateUserSpring {
	
	private static final Logger logger = Logger.getLogger(ValidateUserSpring.class);
	
	@Autowired
	UserDao userDao;
	
	public Integer validateUser(UserData userData) {
    	
	    Integer result = userDao.validateUser(userData);
	    logger.info("result: "+result);
	    return result;
	    
	}
}
