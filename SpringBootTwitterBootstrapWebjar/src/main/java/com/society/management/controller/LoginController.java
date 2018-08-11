package com.society.management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.society.management.domain.User;
import com.society.management.entity.UserInfo;
import com.society.management.service.UserServices;

@Controller
public class LoginController extends WebMvcConfigurerAdapter {
	
	@Autowired
	private UserServices userServices;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/HomeMenu").setViewName("HomeMenu");
	}

	@GetMapping("/")
	public String showForm(User user) {
		return "videoLogin2";
	}

	@PostMapping("/")
	public ModelAndView validateLoginInfo(ModelAndView userMap, @Valid User user, BindingResult bindingResult) {
		UserInfo existingUser = userServices.findByEmail(user.getEmail());
		if(existingUser!=null  ){
			if(existingUser.isEnabled()){
				boolean passwordMatch = bCryptPasswordEncoder.matches(user.getPassword(), existingUser.getPassword());
				if(passwordMatch){
					userMap.addObject("welcomeUser","Welcome " +existingUser.getFirstName()+ " "+existingUser.getLastName());
					userMap.setViewName("HomeMenu");
					return userMap;
				}else{
					userMap.addObject("usernamePasswordDoesntMatch", "Username or password is incorrect ");
				}
			}
			else{
				userMap.addObject("nonActiveEmail", "This Email Address is not active please click the confirmation link sent to the corresponding email " + user.getEmail());
			}
		}else{
			userMap.addObject("usernamePassworDoesntMatch", "Username or password is incorrect ");
		}
		userMap.setViewName("videoLogin2");
		return userMap;
	}
}
