package com.society.management.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.society.management.domain.User;
import com.society.management.entity.RoleInfo;
import com.society.management.entity.UserInfo;
import com.society.management.service.EmailService;
import com.society.management.service.RoleServices;
import com.society.management.service.UserServices;
import com.society.management.util.RoleEnum;

@Controller
public class RegistrationController {
	@Autowired
	private UserServices userServices;
	@Autowired
	private RoleServices roleServices;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private EmailService emailService;

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView registration( ModelAndView userMap,@ModelAttribute("user") @Valid User user, BindingResult bindingResult, HttpServletRequest request)
			throws IllegalAccessException, InvocationTargetException {
		UserInfo userInfo = new UserInfo();
		BeanUtils.copyProperties(userInfo, user);
		UserInfo userExists = userServices.findByEmail(userInfo.getEmail());

		System.out.println(userExists);
		if (userExists != null) {
			userMap.addObject("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");
			userMap.setViewName("videoLogin2");
			bindingResult.reject("email");
}
		if (bindingResult.hasErrors()) { 
			userMap.setViewName("videoLogin2");		
		}
		else { // new user so we create user and send confirmation e-mail
			
			// Disable user until they click on confirmation link in email
			userInfo.setEnabled(false);
		      
		    // Generate random 36-character string token for confirmation link
			userInfo.setConfirmationToken(UUID.randomUUID().toString());
		        
		    userServices.save(userInfo);
				
			String appUrl = request.getScheme() + "://" + request.getServerName()+":8080/lotusBoulevard";
			
			SimpleMailMessage registrationEmail = new SimpleMailMessage();
			registrationEmail.setTo(userInfo.getEmail());
			registrationEmail.setSubject("Registration Confirmation");
			registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
					+ appUrl + "/confirm?token=" + userInfo.getConfirmationToken());
			registrationEmail.setFrom("simplifiedsolution@gmail.com");
			
			emailService.sendEmail(registrationEmail);
			
			userMap.addObject("confirmationMessage", "A confirmation e-mail has been sent to " + user.getEmail());
			userMap.setViewName("videoLogin2");
		}
			
		/*userInfo.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userInfo.setStatInd(1);
		RoleInfo userRole = roleServices.findByRole(RoleEnum.GUEST.name());
		userInfo.setRoleInfo(new HashSet<RoleInfo>(Arrays.asList(userRole)));
		userServices.save(userInfo);
		userServices.doRegistration(userInfo);
		return "HomeMenu";*/
		return userMap;
	}
	
	// Process confirmation link
	@RequestMapping(value="/confirm", method = RequestMethod.GET)
	public ModelAndView confirmRegistration(ModelAndView modelAndView, @RequestParam("token") String token) {
			
		UserInfo user = userServices.findByConfirmationToken(token);
			
		if (user == null) { // No token found in DB
			modelAndView.addObject("invalidToken", "Oops!  This is an invalid confirmation link.");
		} else { // Token found
			modelAndView.addObject("confirmationToken", user.getConfirmationToken());
		}
			
		modelAndView.setViewName("confirm");
		return modelAndView;		
	}

}
