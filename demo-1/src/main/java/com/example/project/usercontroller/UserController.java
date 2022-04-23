package com.example.project.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.project.userdomain.User;
import com.example.project.userservice.UserService;

@Controller
public class UserController {
	
	//@Autowired
	//BCryptPasswordEncoder pwEncoder;
	
	@Autowired
	UserService userService;
	
	@GetMapping(value="/")
	public String login(Model model) {
		model.addAttribute("newuser", new User());
		return "page";
	}
	
	@GetMapping(value="/logout")
	public String logout() {
		return "info";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String register(@ModelAttribute("newuser") User user,Model model) {
		userService.save(user);
		model.addAttribute("user",user);
		return "info";
	}
	
	/*@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveNewAccount(User user) {
		user.setUserPassword(user.getUserPassword());
		userService.save(user);
		return "info";
	}*/
}