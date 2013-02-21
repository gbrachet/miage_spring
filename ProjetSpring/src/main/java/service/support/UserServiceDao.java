package service.support;

import service.UserService;
import dao.UserDao;
import domain.User;

/**
 * Class implémentant le services de gestion des utilisateurs pour la base de données
 * @author BALLAND Cyriel (cyr.balland@gmail.com) - BRACHET Gautier (g.brachet@gmail.com)
 * @version 1.0 (01/02/2013)
 */
public class UserServiceDao extends UserService {
	
	/* Attributs */
	
	private static long DELAY = 60; 	//Secondes
	
	/** DAO gérant les interactions avec la base de données pour les utilisateurs */
	private UserDao userDao;

	/* Méthodes */
	
	@Override
	public void addUser(User user) {
		//Appel du DAO
		this.userDao.addUser(user);
	}
	
	@Override
	public void updateUser(User user) {
		//Appel du DAO
		this.userDao.updateUser(user);
		
	}
	
	@Override
	public void deleteUser(int id) {
		//Appel du DAO
		this.userDao.deleteUser(id);
	}
	
	@Override
	public void deleteUser(User user) {
		//Appel du DAO
		this.deleteUser(user.getIdUser());
	}
	
	@Override
	public boolean emailExists(String email) {
		//Appel du DAO
		return this.userDao.emailExists(email);
	}
	
	@Override
	public User connect(String email, String password) {
		//Récupération de l'utilisateur
		User user = this.userDao.connect(email, password);
		
		//Si connecté
		if(user != null){
			//Ajout au connecté
			this.users.put(user, System.currentTimeMillis());
		}
		
		//Retour du résultat
		return user;
	}
	
	@Override
	public boolean isOnline(User user) {
		boolean result = false;
		Long u = this.users.get(user);
		
		if((u != null) && (System.currentTimeMillis() - u > DELAY)){
			this.users.remove(user);
		}
		
		for(User current : this.users.keySet()){
			if(current.equals(user)){
				result = true;
				break;
			}
		}

		return result;
	}
	
	@Override
	public User getUser(long id) {
		return this.userDao.getUser(id);
	}

	/* Set */
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
