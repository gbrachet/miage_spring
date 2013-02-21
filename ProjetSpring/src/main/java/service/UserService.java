package service;

import java.util.Map;

import domain.User;


/**
 * Interface décrivant les différentes méthodes proposé par le service des utilisateurs
 * @author BALLAND Cyriel (cyr.balland@gmail.com) - BRACHET Gautier (g.brachet@gmail.com)
 * @version 1.0 (01/02/2013)
 */
public abstract class UserService {
	
	/* Attributs */
	
	/** Liste contenant les utilisateurs en mémoire (connecté) */
	protected Map<User, Long> users;
	
	/* Méthodes */

	/**
	 * Méthode permettant d'ajouter un nouvel utilisateur
	 * @param (User) user : l'utilisateur à ajouter
	 */
	public abstract void addUser(User user);
	
	/**
	 * Méthode permettant de mettre un jour un utilisateur
	 * @param (User) user : l'utilisateur à mettre à jour
	 */
	public abstract void updateUser(User user);
	
	/**
	 * Méthode permettant de supprimer un utilisateur
	 * @param (int) id : l'identifiant de l'utilisateur
	 */
	public abstract void deleteUser(int id);
	
	/**
	 * Méthode permettant de supprimer un utilisateur
	 * @param (User) user : l'utilisateur à supprimer
	 */
	public abstract void deleteUser(User user);
	
	/**
	 * Méthode permettant de savoir si un email existe déjà ou non
	 * @param (String) email : l'email
	 * @return boolean true si il existe, false sinon
	 */
	public abstract boolean emailExists(String email);
	
	/**
	 * Méthode permettant de se connecter
	 * @param (String) email
	 * @param (String) password
	 * @return (User) si l'utilisateur est trouvé, null sinon
	 */
	public abstract User connect(String email, String password);

	/**
	 * Méthode permettant de récupérer un utilisateur
	 * @param (long) identifiant
	 * @return (User) l'utilisateur
	 */
	public abstract User getUser(long id);
	
	public abstract boolean isOnline(User user);
	
	/* Set */

	/**
	 * Méthode permettant de définir la liste des utilisateurs connectés
	 * @param (Map<User, Long>) users
	 */
	public void setUsers(Map<User, Long> users) {
		this.users = users;
	}
	
	public Map<User, Long> getUsers() {
		return users;
	}
	

	
}
