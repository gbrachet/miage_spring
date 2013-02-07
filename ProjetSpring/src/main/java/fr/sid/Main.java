package fr.sid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.sid.domain.User;
import fr.sid.service.UserService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//UserService service = (UserService)ctx.getBean("userService");
		//UserService service = ctx.getBean(UserService.class);
		UserService service = ctx.getBean("userService", UserService.class);
		
		//Instanciation
		User user = new User();
		
		//Paramètrage
		user.setUsername("g.brachet");
		user.setEmail("g.brachet@gmail.com");
		user.setPassword("123456");
		
		//Ajout
		service.addUser(user);
		
		//Parcours
		for(User courant : service.getUsers()){
			//Affichage
			System.out.println(courant);
		}
	}
}
