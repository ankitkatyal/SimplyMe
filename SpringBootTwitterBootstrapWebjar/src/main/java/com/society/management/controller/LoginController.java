package com.society.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.society.management.domain.User;
  
@Controller
public class LoginController {
	
    @RequestMapping(value="/",method = RequestMethod.GET)
    public String home(){
        return "videoLogin";
    }
    

    @RequestMapping(value="",method = RequestMethod.POST)
    public String Greeting(@ModelAttribute("user") User user,ModelMap userMap){
    	
    	userMap.addAttribute("username", user.getId());
    	userMap.addAttribute("password", user.getPassword());
    	
    	System.out.println(user.getId());
    	System.out.println(user.getPassword());
        return "sidebar";
        
        
    }
}