package com.walichin.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.walichin.common.ConvertListUser;
import com.walichin.common.ConvertNewUser;
import com.walichin.common.ConvertValidateUser;

@Controller
public class MainUserController {
	
	@Autowired
	ConvertListUser convertListUser;
	
	@Autowired
	ConvertNewUser convertNewUser;
	
	@Autowired
	ConvertValidateUser convertValidateUser;
	
//	@RequestMapping("/users/html")
//	public ModelAndView usersHtml() {
//
//		System.out.println("/users/html");
//	    List<UserForm> list = convertListUser.convertListUser();
//	    ModelAndView model = new ModelAndView();
//	    model.addObject("list", list);
//		model.setViewName("users");
//		return model;
//	}
//	
//	@RequestMapping("/users/json")
//	public String usersJson(Model model) {
//
//		System.out.println("/users/json");
//		List<UserForm> list = convertListUser.convertListUser();
//		model.addAttribute("list", list);
//		return "jsonOutput";
//	}
//	
//	@RequestMapping("/users/xml")
//	public String usersXml(Model model) {
//
//		System.out.println("/users/xml");
//		List<UserForm> list = convertListUser.convertListUser();
//		model.addAttribute("list", list);
//		return "xmlOutput";
//	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String users(Model model,
			@RequestParam(value="format", required=false) String format) {

		System.out.println("/users");
		
		if (format == null) format = "json";
		
		System.out.println("get.parameter.format: " + format);
		
		List<UserForm> users = convertListUser.convertListUser();
		
		model.addAttribute("users", users);
		
		if (format.equals("json")) return "jsonOutput";
		
		if (format.equals("xml")) return "xmlOutput";
		
		return "users";
		
	}
	
	@RequestMapping("/newUserInput")
	public ModelAndView newUserInput() {

		System.out.println("/newUserInput");
		ModelAndView model = new ModelAndView();
		UserForm userForm = new UserForm();
		model.addObject("userForm", userForm);
		model.setViewName("newUserInput");
		return model;
	}
	
//	@RequestMapping("/newUser")
//	public ModelAndView newUser(@ModelAttribute(value = "userForm") UserForm userForm) {
//
//		System.out.println("/newUser");
//		System.out.println("userForm.name: " + userForm.getName());
//		ModelAndView model = new ModelAndView();
//		Date nowDate = new Date();
//		model.addObject("userForm", userForm);
//		model.addObject("nowDate", nowDate);
//		
//		boolean resultado = convertNewUser.convertNewUser(userForm);
//		
//		if (resultado) {
//			model.setViewName("userCreated");
//		} else {
//			model.setViewName("errorNewUser");
//		}
//		return model;
//	}
	
	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public String newUser(Model model,
			@RequestParam(value="name", required=false) String name,
			@RequestParam(value="login", required=false) String login,
			@RequestParam(value="password", required=false) String password,
			@RequestParam(value="format", required=false) String format,
			@RequestParam(value="email", required=false) String email,
			@RequestParam(value="is_admin", required=false) String is_admin,
			@RequestParam(value="url_photo", required=false) String url_photo,
			@RequestParam(value="gps_latitude", required=false) String gps_latitude,
			@RequestParam(value="gps_longitude", required=false) String gps_longitude,
			@RequestParam(value="gps_location", required=false) String gps_location) {
			
		System.out.println("/newUser");
		
		System.out.println("http.parameter.name: " + name);
		System.out.println("http.parameter.login: " + login);
		System.out.println("http.parameter.password: " + password);
		System.out.println("http.parameter.email: " + email);
		System.out.println("http.parameter.is_admin: " + is_admin);
		System.out.println("http.parameter.url_photo: " + url_photo);
		System.out.println("http.parameter.gps_latitude: " + gps_latitude);
		System.out.println("http.parameter.gps_longitude: " + gps_longitude);
		System.out.println("http.parameter.gps_location: " + gps_location);
		System.out.println("http.parameter.format: " + format);		
		
		Integer result;
		Date nowDate = new Date();
		
		if (format == null) format = "json";
		
		if (name == null || login == null || password == null) {
			
			result = -1;
			if (name == null) name = "<null>";
			
		} else {
			
			if (email == null) email = "";
			if (is_admin == null) is_admin = "";
			if (url_photo == null) url_photo = "";
			if (gps_latitude == null) gps_latitude = "";
			if (gps_longitude == null) gps_longitude = "";
			if (gps_location == null) gps_location = "";
			
			UserForm userForm = new UserForm();
			
			userForm.setName(name);
			userForm.setLogin(login);
			userForm.setPassword(password);
			userForm.setEmail(email);
			userForm.setIs_admin(is_admin);
			userForm.setUrl_photo(url_photo);
			userForm.setGps_latitude(gps_latitude);
			userForm.setGps_longitude(gps_longitude);
			userForm.setGps_location(gps_location);
			
			if (convertNewUser.convertNewUser(userForm)) result = 1;
			else result = 0;
		}
		
		model.addAttribute("result", result.toString());
		
		if (format.equals("json")) return "jsonOutput";
		
		if (format.equals("xml")) return "xmlOutput";
		
		String status;
		
		if (result > 0) {
			status = "OK";
		} else {
			status = "FAIL";
		}
		
		model.addAttribute("name", name);
		model.addAttribute("nowDate", nowDate);
		model.addAttribute("status", status);
		
		return "userCreation";
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model,
			@RequestParam(value="login", required=false) String login,
			@RequestParam(value="password", required=false) String password,
			@RequestParam(value="format", required=false) String format) {

		System.out.println("/login");
		
		Integer result;
		Date nowDate = new Date();
		
		if (format == null) format = "json";
		
		if (login == null || password == null) {
			
			result = -1;
			if (login == null) login = "<null>";
			
		} else {
			
			System.out.println("get.parameter.login: " + login);
			System.out.println("get.parameter.password: " + password);
			System.out.println("get.parameter.format: " + format);
			
			UserLogin userLogin = new UserLogin();
			userLogin.setLogin(login);
			userLogin.setPassword(password);
			result = convertValidateUser.convertValidateUser(userLogin);
		}
		
		model.addAttribute("result", result.toString());
		
		if (format.equals("json")) return "jsonOutput";
		
		if (format.equals("xml")) return "xmlOutput";
		
		String status;
		
		if (result > 0) {
			status = "OK";
		} else {
			status = "FAIL";
		}
		
		model.addAttribute("login", login);
		model.addAttribute("nowDate", nowDate);
		model.addAttribute("status", status);
		
		return "userValidation";
		
	}
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {

		System.out.println("/welcome");

		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Welcome! **********</h3>"
				+ "<br>This is a test message</div><br><br>";
		
		return new ModelAndView("welcome", "message", message);
	}

}
