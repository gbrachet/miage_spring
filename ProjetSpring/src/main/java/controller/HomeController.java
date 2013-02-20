package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.UserService;

@Controller
public class HomeController {
	
	/* Constantes */
	
	/** Page de connexion */
	private static String WELCOME = "redirect:signin";
	
	/* Attributs */
	
	/** Gestionnaire utilisateur */
	@Autowired
	private UserService userService;
	
	/* Méthodes */
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String doGet(ModelMap model){
		//Si non connecté
		if(!this.userService.isConnected()) return WELCOME; 
		
		
		//Retour du résultat
		return "home";
	}
	
	/* Set */
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
