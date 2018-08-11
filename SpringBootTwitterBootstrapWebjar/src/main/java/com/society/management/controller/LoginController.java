package com.society.management.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.society.management.domain.User;
import com.society.management.entity.UserInfo;
import com.society.management.service.UserServices;

@Controller
public class LoginController extends WebMvcConfigurerAdapter{
	@Autowired
	private UserServices userServices;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/HomeMenu").setViewName("HomeMenu");
    }
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("user", new User());
		return "videoLogin2";
	}
	
	@PostMapping("/login")
    public String validateLoginInfo(Model model, @Valid User loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        model.addAttribute("user", loginForm.getEmail());
        return "HomeMenu";
    }
	
	@GetMapping("/login1")
    public String showForm(User loginForm) {
        return "videoLogin2";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Greeting(@ModelAttribute("user") User user, ModelMap userMap, BindingResult bindingResult, HttpServletRequest request) {
		if(userServices.findByEmail(user.getEmail())!=null){
			
		}
		if (bindingResult.hasErrors()) { 
			System.out.println(bindingResult.getAllErrors());	
			
		}
		userMap.addAttribute("username", user.getEmail());
		userMap.addAttribute("password", user.getPassword());
		return "HomeMenu";

	}
	
	@RequestMapping(value = "/login1", method = RequestMethod.POST)
	public ModelAndView Greeting( ModelAndView userMap,@ModelAttribute("user") @Valid User user, BindingResult bindingResult, HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {
		if(userServices.findByEmail(user.getEmail())!=null  ){
			UserInfo existingUser = userServices.findByEmail(user.getEmail());
			if(existingUser.isEnabled()){
				String encryptPassword = bCryptPasswordEncoder.encode(user.getPassword());
				if(encryptPassword.equals(existingUser.getPassword())){
					userMap.addObject("confirmationMessage", "Redirecting to homepage ");
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