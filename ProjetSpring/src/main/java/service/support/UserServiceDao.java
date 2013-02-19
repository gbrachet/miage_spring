package service.support;

import java.util.List;
import java.util.Map;

import service.UserService;

import dao.UserDao;
import domain.User;

/**
 * Class implémentant le services de gestion des utilisateurs pour la base de données
 * @author BALLAND Cyriel (cyr.balland@gmail.com) - BRACHET Gautier (g.brachet@gmail.com)
 * @version 1.0 (01/02/2013)
 */
public class UserServiceDao implements UserService {
	
	/* Attributs */
	
	/** DAO gérant les interactions avec la base de données pour les utilisateurs */
	private UserDao userDao;
	
	/** Liste contenant les utilisateurs en mémoire (connecté) */
	@SuppressWarnings("unused")
	private Map<Integer, User> users;

	/* Méthodes */
	
	@Override
	public void addUser(User user) {
		//Appel du DAO
		userDao.addUser(user);
	}
	
	@Override
	public void updateUser(User user) {
		//Appel du DAO
		userDao.updateUser(user);
		
	}
	
	@Override
	public void deleteUser(int id) {
		//Appel du DAO
		userDao.deleteUser(id);
	}
	
	@Override
	public void deleteUser(User user) {
		//TODO Vérification de l'utilisateur
		if((user == null) || (user.getIdUser() < 1)){
			//Levée d'une exception
//			throw new ControlException();
		}
		
		//Appel de la méthode sur l'identifiant
		this.deleteUser(user.getIdUser());
	}
	
	/* TODO */

	
	@Override
	public List<User> getUsers() {
		//Retour du résultat du DAO
		return userDao.getUsers();
	}

	@Override
	public User getUser(String uuid) {
		// TODO Auto-generated method stub
		return null;
//		return userDao.getUser(uuid);
	}

	





	/* Set */
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setUsers(Map<Integer, User> users) {
		this.users = users;
	}
	
	


}
