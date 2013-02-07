package fr.sid.domain;

import java.util.Date;

/**
 * Classe modélisant un utilisateur
 * @author BALLAND Cyriel (cyr.balland@gmail.com) - BRACHET Gautier (g.brachet@gmail.com)
 * @version 1.0 (01/02/2013)
 */
public class User {
	
	/* Attributs */
	
	private int idUtilisateur;
	
	private String username;
	private String password;
	private String email;
	
	private String firstName;
	private String lastName;
	private String sex;				//'m', 'f'
	private Date birthday;
	
	private Date lastConnection;
	private Date registration;
	
	/* Constructeurs */

	/**
	 * Constructeur vide
	 */
	public User() {
		
	}
	
	/* Méthodes */

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof User)? (this.idUtilisateur == ((User) obj).getIdUtilisateur()) : super.equals(obj);
	}
	
	public String toString(){
		return "id : "+this.idUtilisateur+", username : "+this.username+", email : "+this.email; 
	}


	/* Get & Set */
	
	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getLastConnection() {
		return lastConnection;
	}

	public void setLastConnection(Date lastConnection) {
		this.lastConnection = lastConnection;
	}

	public Date getRegistration() {
		return registration;
	}

	public void setRegistration(Date registration) {
		this.registration = registration;
	}
}
