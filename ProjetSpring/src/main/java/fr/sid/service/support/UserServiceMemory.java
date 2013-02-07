package fr.sid.service.support;

import java.util.List;
import java.util.Map;

import fr.sid.domain.User;
import fr.sid.service.UserService;

/**
 * Class implémentant le services de gestion des utilisateurs en mémoire vive
 * @author BALLAND Cyriel (cyr.balland@gmail.com) - BRACHET Gautier (g.brachet@gmail.com)
 * @version 1.0 (01/02/2013)
 */
public class UserServiceMemory implements UserService{
	
	/* Attributs */
	
	/** Liste contenant les utilisateurs en mémoire */
	private Map<Integer, User> users;
	
	/* Constructeurs */
	
	public UserServiceMemory(){
		
	}
	
	/* Méthodes */

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public User getUser(String uuid) {
//		for(User u : users){
//			if(u.getUuid().equals(uuid)){
//				return u;
//			}
//		}
		return null;
	}
	
	public void addUser(User user) {
//		if(!users.contains(user)){
//			users.add(user);
//		}
	}

	public void updateUser(User user) {

		addUser(user);
	}

	public void deleteUser(String uuid) {
		User u = getUser(uuid);
		if(u != null){
			users.remove(u);
		}
	}
	
	/* Set */
	
	public void setUsers(List<User> users) {
		this.users = users;
	}


}
