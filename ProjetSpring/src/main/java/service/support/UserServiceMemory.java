package service.support;

import java.util.List;
import java.util.Map;

import service.UserService;
import domain.User;


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
	@Override
	public User getUser(String uuid) {
//		for(User u : users){
//			if(u.getUuid().equals(uuid)){
//				return u;
//			}
//		}
		return null;
	}
	@Override
	public void addUser(User user) {
//		if(!users.contains(user)){
//			users.add(user);
//		}
	}
	@Override
	public void updateUser(User user) {

		addUser(user);
	}

	
	@Override
	public boolean emailExists(String email) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public User connect(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void setUser(User user) {
		// TODO Auto-generated method stub
		
	}
	
	
	/* Set */
	
	public void setUsers(Map<Integer, User> users) {
		this.users = users;
	}


}
