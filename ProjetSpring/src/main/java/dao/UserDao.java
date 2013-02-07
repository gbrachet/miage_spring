package dao;

import java.util.List;

import fr.sid.domain.User;

/**
 * Interface décrivant les différentes méthodes proposé par le DAO des utilisateurs
 * @author BALLAND Cyriel (cyr.balland@gmail.com) - BRACHET Gautier (g.brachet@gmail.com)
 * @version 1.0 (01/02/2013)
 */
public interface UserDao {

	/**
	 * Méthode permettant d'ajouter un nouvel utilisateur
	 * @param (User) user : l'utilisateur à ajouter
	 */
	public void addUser(User user);
	
	/**
	 * Méthode permettant de mettre un jour un utilisateur
	 * @param (User) user : l'utilisateur à mettre à jour
	 */
	public void updateUser(User user);
	
	/**
	 * Méthode permettant de supprimer un utilisateur
	 * @param (int) id : l'identifiant de l'utilisateur
	 */
	public void deleteUser(int id);
	
	/**
	 * Méthode permettant de connecter un utilisateur
	 * @param (String) username : l'identifiant de connexion
	 * @param (String) password : le mot de passe
	 */
	public User connection(String username, String password);
	
	/**
	 * Méthode permettant de récupérer un utilisateur
	 * @param (int) id : l'identifiant de l'utilisateur
	 * @return (User) l'utilisateur
	 */
	public User getUser(int id);
	
	public List<User> getUsers();

	
	public User getUserByMail(String mail);
	

}
