package dao;

import java.util.List;

import domain.User;


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
	
	/**
	 * Méthode permettant de récupérer la liste des utilisateurs
	 * @return (List<User>) la liste des utilisateurs
	 */
	public List<User> getUsers();
	
	/**
	 * Méthode permettant de savoir si un email existe déjà ou non
	 * @param (String) email : l'email
	 * @return boolean true si il existe, false sinon
	 */
	public boolean emailExists(String email);
	
	/**
	 * Méthode permettant de se connecter
	 * @param (String) email
	 * @param (String) password
	 * @return (User) si l'utilisateur est trouvé, null sinon
	 */
	public User connect(String email, String password);

	
	public User getUserByMail(String mail);
	

}
