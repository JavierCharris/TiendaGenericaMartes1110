package com.tienda.mintic.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class AppController {
		
	@GetMapping({"/","/login"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/error")
	public String error() {
		return "error";
	}
	
	@GetMapping("/productos")
	public String productos() {
		return "productos";
	}
	
	@GetMapping("/salir")
	public String salir() {
		return "salir";
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	@GetMapping("/usuarios")
	public String usuarios() {
		return "usuarios";
	}
	
	@RequestMapping("/validador")
	public String validador( HttpServletRequest req, HttpServletRequest resp) {
	
		String usuario = req.getParameter("usuario");
		String password = req.getParameter("password");
		
		if(usuario.equals("1") && password.equals("1") ) {
			return "menu";
		}else {
			return "error";
		}		
		
	}

	
	
	
	
	
		
}



	

