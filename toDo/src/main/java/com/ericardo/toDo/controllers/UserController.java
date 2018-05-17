package com.ericardo.toDo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ericardo.toDo.models.User;
import com.ericardo.toDo.services.UserService;


@Controller
@RequestMapping("/users/")
public class UserController {

	private UserService _uS;
	
	public UserController(UserService _uS) {
		this._uS = _uS;
	}
	
	// LOGIN - REGISTER ROUTE
	@RequestMapping("/login")
	public String newUser(@ModelAttribute("user") User user, HttpSession _session) {
		_uS.logout(_session);
		return "login_register";
	}
	
	// REGISTER ROUTE
	@PostMapping("/newUser")
	public String create(@Valid @ModelAttribute("user") User user, BindingResult _result, RedirectAttributes _flash, HttpSession _session) {
		if(_result.hasErrors()) {
			_flash.addFlashAttribute("errors", _result.getAllErrors());
			return "redirect:/users/login";
		} else {
			User exists = _uS.findByEmail(user.getEmail());
			
			if(exists == null) {
				User _user = _uS.create(user);
				_uS.login(_session, _user.getId());
				return "redirect:/tasks";
			} else {
				_flash.addFlashAttribute("error", "A user with this e-mail already exists.");
				return "redirect:/users/login";
			}
		}
	}
	
	// LOGIN ROUTE
	@PostMapping("/loginUser")
	public String login(@RequestParam("email") String email,@RequestParam("password") String password,HttpSession _session,RedirectAttributes _flash){
		if(email.length() < 1){// Dont waste a query.
			_flash.addFlashAttribute("error","Email cannot be blank.");
			return "redirect:/users/login";			
		}

		User user = _uS.findByEmail(email);

		if(user == null){
			_flash.addFlashAttribute("error","No user with this email was found.");
			return "redirect:/users/login";
		}else{
			if(_uS.isMatch(password,user.getPassword())){
				_uS.login(_session,user.getId());
				return "redirect:/tasks";		
			}else{
				_flash.addFlashAttribute("error","Invalid Credentials");
				return "redirect:/users/login";								
			}
		}
	}
	
	// LOG OUT
	@RequestMapping("/logout")
	public String logout(HttpSession _session) {
		return _uS.redirect();
	}

}

