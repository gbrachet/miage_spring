package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.UserService;
import domain.User;


@Controller
public class WelcomeController {
	
	/* Constantes */
	
	/** Adresse après connexion */
	private static String HOME = "redirect:home";
	
	/* Attributs */
	
	/** Service de gestion des user */
	@Autowired
	private UserService userService;
	
	/** Logger */
//	private static Logger LOG = Logger.getLogger(WelcomeController.class);
	
	/* Méthodes */

	/**
	 * Méthode de la page d'accueil
	 * @param (ModelMap) model
	 * @return JSP à afficher
	 */
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String doWelcome(ModelMap model){
		//Si déjà connecté
		if(this.userService.isConnected()) return HOME;
		
		//Attributs
		model.addAttribute("userForm", new UserForm());
		model.addAttribute("user", new User());
		model.addAttribute("tab", "signin");
		
		//Retour du résultat
		return "welcome";
	}
	
	/**
	 * Méthode gérant la connexion
	 */
	@RequestMapping(value="/signin", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute("user") final User user, final BindingResult bindingResult, final Model model){
		//Si déjà connecté
		if(this.userService.isConnected()) return HOME;
		
		//Initialisation 
		String result = "welcome";
		
		//Si il n'y a pas des erreurs
		if(!bindingResult.hasErrors()) {
			//Connexion
			this.userService.setUser(this.userService.connect(user.getEmail(), user.getPassword()));
			
			//Si connexion ok
			if(this.userService.isConnected()){
				//Redirection
				result = HOME;
			}
			else{
				bindingResult.rejectValue("email", "email", "Email Address or Password invalid");
			}
		}
		
		//Attributs
		model.addAttribute("tab", "signin");
		model.addAttribute("userForm", new UserForm());
		
		//Retour du résultat
		return result;
	}
	
	/**
	 * Méthode de la page de connexion GET
	 */
	@RequestMapping(value="/signin", method = RequestMethod.GET)
	public String doLoginGet(ModelMap model){
		//Si déjà connecté
		if(this.userService.isConnected()) return HOME;
		
		//Attributs
		model.addAttribute("userForm", new UserForm());
		model.addAttribute("user", new User());
		model.addAttribute("tab", "signin");
		
		//Retour du résultat
		return "welcome";
	}

	/**
	 * Méthode de la page d'inscription GET
	 */
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String doRegisterGet(ModelMap model){
		//Si déjà connecté
		if(this.userService.isConnected()) return HOME;
	
		//Attributs
		model.addAttribute("userForm", new UserForm());
		model.addAttribute("user", new User());
		model.addAttribute("tab", "register");
		
		//Retour du résultat
		return "welcome";
	}
	
	/**
	 * Méthode de la page d'inscription POST
	 */
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String doRegister(@ModelAttribute("userForm") @Valid final UserForm userForm, final BindingResult bindingResult, final Model model){
		//Si déjà connecté
		if(this.userService.isConnected()) return HOME;
		
		//Initialisation
		String result = "welcome";
		Date birthday = null;
		
		try {
			//Date d'anniversaire
			birthday = (userForm.getBirthday() != null)? new SimpleDateFormat("dd/MM/yyyy").parse(userForm.getBirthday()) : null;
		} catch (ParseException e) {
			//Erreur
			bindingResult.rejectValue("birthday", "birthday0", "Birthday invalid");
			
			//RàZ
			birthday = null;
		}
		
		//Vérification confirmation
		if(!userForm.getPassword().equals(userForm.getPasswordConfirm())){
			bindingResult.rejectValue("passwordConfirm","passwordConfirm", "Password Confirm invalid (must be the same)");
		}
		
		//Vérification date d'anniversaire
		if((birthday != null) && (birthday.compareTo(new Date()) >= 0)){
			bindingResult.rejectValue("birthday", "birthday1", "Birthday invalid (must be in the past)");
		}
		
		//Vérification de l'existence de l'email
		if((userForm.getEmail() != null) && (this.userService.emailExists(userForm.getEmail()))){
			bindingResult.rejectValue("email", "email0", "This Email Address already exists.");
		}
		
		//Si il n'y a pas des erreurs
		if(!bindingResult.hasErrors()) {
			//Nouvel utilisateur
			User user = new User();
			user.setEmail(userForm.getEmail());
			user.setPassword(userForm.getPassword());
			user.setSex(userForm.getSex());
			user.setBirthday(birthday);

			//Ajout
			this.userService.addUser(user);
			
			//Connexion
			this.userService.setUser(user);
			
			//Redirection
			result = HOME;
		}
		
		//Attributs
		model.addAttribute("tab", "register");
		model.addAttribute("user", new User());
		
		//Retour du résultat
		return result;
	}
	
	/**
	 * Méthode gérant la déconnexion
	 */
	@RequestMapping(value="/logout", method = RequestMethod.POST)
	public String doLogout(final Model model){
		//Déconnexion
		this.userService.setUser(null);
		
		//Redirection
		return "redirect:/signin";
	}
	
	/* Set */
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
