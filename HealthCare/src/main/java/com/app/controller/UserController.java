package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.User;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;

	@RequestMapping("/register")
	public String showUserForm(ModelMap map) {
		map.addAttribute("user", new User());
		return "RegisterUser";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute User user, ModelMap map) {
		String msg = null;
		Integer id = 0;
		id = service.saveUser(user);
		msg = "User Registered with " + id + " ...";
		map.addAttribute("message", msg);
		map.addAttribute("user", new User());
		return "RegisterUser";
	}

	@RequestMapping("/all")
	public String showAllUsers(ModelMap map) {
		List<User> listUsers = null;
		listUsers = service.getAllUsers();
		map.addAttribute("listUsers", listUsers);
		return "AllUsers";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String removeUser(@RequestParam("id") Integer userId, ModelMap map) {
		String msg = null;
		List<User> listUsers = null;
		service.deleteUser(userId);
		msg = "User Registered with " + userId + " ...";
		map.addAttribute("message", msg);
		listUsers = service.getAllUsers();
		map.addAttribute("listUsers", listUsers);
		return "AllUsers";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editUser(@RequestParam("id") Integer userId, ModelMap map) {
		User user = null;
		user = service.getOneUser(userId);
		map.addAttribute("user", user);
		return "EditUser";
	}

	@RequestMapping(value = "/update")
	public String updateUser(@ModelAttribute User user, ModelMap map) {
		List<User> listUsers = null;
		service.updateUser(user);
		String msg=null;
		listUsers = service.getAllUsers();
		msg="User updated with Id "+user.getUserId()+"...";
		map.addAttribute("listUsers", listUsers);
		map.addAttribute("message", msg);
		map.addAttribute("empId", user.getUserId());
		return "AllUsers";
	}
	
	@RequestMapping("/get")
	public String showOneUser(@RequestParam("id") Integer userId,ModelMap map) {
		User listUsers = null;
		listUsers = service.getOneUser(userId);
		map.addAttribute("listUsers", listUsers);
		return "OneUser";
	}

}
