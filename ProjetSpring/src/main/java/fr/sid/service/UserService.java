package fr.sid.service;

import java.util.List;

import fr.sid.domain.User;

/**
 * Interface décrivant les différentes méthodes proposé par le service des utilisateurs
 * @author BALLAND Cyriel (cyr.balland@gmail.com) - BRACHET Gautier (g.brachet@gmail.com)
 * @version 1.0 (01/02/2013)
 */
public interface UserService {

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
	 * Méthode permettant de supprimer un utilisateur
	 * @param (User) user : l'utilisateur à supprimer
	 */
	public void deleteUser(User user);

	/**
	 * Méthode permettant de récupérer la liste des utilisateurs
	 * @return (List<User>) la liste des utilisateurs
	 */
	public List<User> getUsers();

	public User getUser(String uuid);
	

	

	
}
