package com.ericardo.toDo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ericardo.toDo.models.User;
import com.ericardo.toDo.services.UserService;


@Controller
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private UserService _uS;
	
	// DASHBOARD ROUTE
	@RequestMapping("")
	public String dashboard(Model _model, HttpSession _session) {
		if(!_uS.isValid(_session)) 
			return _uS.redirect();																
		User user = _uS.find( (Long) _session.getAttribute("id") );
		_model.addAttribute("user", user);
		return "dashboard";
	}
	
}
