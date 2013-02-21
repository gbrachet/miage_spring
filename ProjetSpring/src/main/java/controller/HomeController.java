package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.ContactService;
import service.MessageService;
import service.UserService;
import domain.Message;
import domain.User;

@Controller
public class HomeController {
	
	/* Constantes */
	
	/** Page de connexion */
	private static String WELCOME = "redirect:signin";
	
	/* Attributs */
	
	/** Gestionnaire utilisateur */
	@Autowired
	private UserService userService;
	
	/** Gestionnaire de contact */
	@Autowired
	private ContactService contactService;
	
	/** Gestionnaire de message */
	@Autowired
	private MessageService messageService;
	
	/* Méthodes */
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpSession session){
		//Si non connecté
		if((session.getAttribute("user") == null || ((User) session.getAttribute("user")).getEmail() == null)) return WELCOME; 
		
		model.addAttribute("myId", ((User) session.getAttribute("user")).getIdUser());
		
		//Retour du résultat
		return "home";
	}
	
	@RequestMapping(value="/ajaxAutoComplete", method = RequestMethod.GET)
	public @ResponseBody List<User> doAjaxAutoComplete(@RequestParam String begin, HttpSession session){
		//Si non connecté
		if((session.getAttribute("user") == null || ((User) session.getAttribute("user")).getEmail() == null)) return null;
		
		return this.contactService.getContactsComplete(begin, ((User) session.getAttribute("user")).getIdUser());
	}
	
	@RequestMapping(value="/ajaxAddContact", method = RequestMethod.GET)
	public @ResponseBody void doAjaxAddContact(@RequestParam long id, HttpSession session){
		//Si non connecté
		if((session.getAttribute("user") == null || ((User) session.getAttribute("user")).getEmail() == null)) return; 
		
		this.contactService.addContact(id, ((User) session.getAttribute("user")).getIdUser());
	}
	
	@RequestMapping(value="/ajaxRemoveContact", method = RequestMethod.GET)
	public @ResponseBody void doAjaxRemoveContact(@RequestParam long id, HttpSession session){
		//Si non connecté
		if((session.getAttribute("user") == null || ((User) session.getAttribute("user")).getEmail() == null)) return; 
		
		this.contactService.removeContact(id, ((User) session.getAttribute("user")).getIdUser());
	}
	
	@RequestMapping(value="/ajaxSendMessage", method = RequestMethod.GET)
	public @ResponseBody void doAjaxSendMessage(@RequestParam String message, @RequestParam long id, HttpSession session){
		//Si non connecté
		if((session.getAttribute("user") == null || ((User) session.getAttribute("user")).getEmail() == null)) return; 
		
		this.messageService.addMessage(message, ((User) session.getAttribute("user")).getIdUser(), id);
	}
	
	@RequestMapping(value="/ajaxGetContact", method = RequestMethod.GET)
	public @ResponseBody List<User> doAjaxGetContact(HttpSession session){
		//Si non connecté
		if((session.getAttribute("user") == null || ((User) session.getAttribute("user")).getEmail() == null)) return null; 
		
		this.userService.getUsers().put(((User) session.getAttribute("user")), System.currentTimeMillis());
		
		List<User> users = this.contactService.getContacts(((User) session.getAttribute("user")).getIdUser());
		
		for(User current: users){
			current.setOnline(this.userService.isOnline(current));
		}
		
		return users;
	}
	
	@RequestMapping(value="/ajaxGetMessage", method = RequestMethod.GET)
	public @ResponseBody List<User> doAjaxGetMessage(HttpSession session){
		//Si non connecté
		if((session.getAttribute("user") == null || ((User) session.getAttribute("user")).getEmail() == null)) return null; 
		
		List<Message> messages = this.messageService.getMessages(((User) session.getAttribute("user")).getIdUser());
		List<User> result = new ArrayList<User>();
		long userId;
		User user = null;
		
		for(Message current : messages){
			userId = (current.getTo() == ((User) session.getAttribute("user")).getIdUser())? current.getFrom() : current.getTo();
			user = this.userService.getUser(userId);
			
			if(!result.contains(user)){
				user.setMessages(new ArrayList<Message>());
				user.getMessages().add(current);
				result.add(user);
			}
			else{
				for(User u : result){
					if(u.equals(user)){
						u.getMessages().add(current);
					}
				}
			}
		}
		
		return result;
	}
	
	/* Set */
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
