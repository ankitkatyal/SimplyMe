package com.society.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.society.management.domain.User;

@Controller
public class LoginController {

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("user", new User());
		return "videoLogin2";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Greeting(@ModelAttribute("user") User user, ModelMap userMap) {
		userMap.addAttribute("username", user.getEmail());
		userMap.addAttribute("password", user.getPassword());
		return "HomeMenu";

	}
}