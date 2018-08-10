package com.society.management.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;
import com.society.management.domain.User;
import com.society.management.entity.UserInfo;
import com.society.management.service.EmailService;
import com.society.management.service.RoleServices;
import com.society.management.service.UserServices;

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
			userInfo.setTokenExpiryDate(new Date(System.currentTimeMillis()+86400000l));
		    userServices.save(userInfo);
				
			String appUrl = request.getScheme() + "://" + request.getServerName()+":8080/lotusBoulevard";
			
			SimpleMailMessage registrationEmail = new SimpleMailMessage();
			registrationEmail.setTo(userInfo.getEmail());
			registrationEmail.setSubject("Registration Confirmation");
			registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
					+ appUrl + "/confirm?token=" + userInfo.getConfirmationToken()+"\n This link will expire in 24 hours");
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
		}else if(user.getTokenExpiryDate()!=null && user.getTokenExpiryDate().compareTo(new Date(System.currentTimeMillis()))<0){ // Token found
			modelAndView.addObject("invalidToken", "Oops!  This confirmation link is expired");
		}
		else { // Token found
			modelAndView.addObject("confirmationToken", user.getConfirmationToken());
		}
			
		modelAndView.setViewName("confirm");
		return modelAndView;		
	}
	
	// Process confirmation link
	@RequestMapping(value="/confirm", method = RequestMethod.POST)
	public ModelAndView confirmRegistration(ModelAndView modelAndView, BindingResult bindingResult, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {
				
		modelAndView.setViewName("confirm");
		
		Zxcvbn passwordCheck = new Zxcvbn();
		
		Strength strength = passwordCheck.measure(requestParams.get("password"));
		
		if (strength.getScore() < 3) {
			//modelAndView.addObject("errorMessage", "Your password is too weak.  Choose a stronger one.");
			bindingResult.reject("password");
			
			redir.addFlashAttribute("errorMessage", "Your password is too weak.  Choose a stronger one.");

			modelAndView.setViewName("redirect:confirm?token=" + requestParams.get("token"));
			System.out.println(requestParams.get("token"));
			return modelAndView;
		}
	
		// Find the user associated with the reset token
		UserInfo user = userServices.findByConfirmationToken(requestParams.get("token"));

		// Set new password
		user.setPassword(bCryptPasswordEncoder.encode(requestParams.get("password")));

		// Set user to enabled
		user.setEnabled(true);
		
		// Save user
		userServices.save(user);
		
		modelAndView.addObject("successMessage", "Your password has been set!");
		return modelAndView;		
	}

}
