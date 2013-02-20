package domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * Classe modélisant un utilisateur
 * @author BALLAND Cyriel (cyr.balland@gmail.com) - BRACHET Gautier (g.brachet@gmail.com)
 * @version 1.0 (01/02/2013)
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1473400756284729819L;
	
	
	
	/* Attributs */
	
	private int idUser;
	private String username;
	
	@NotNull(message = "Password invalid (6 to 16 caracters)")
	@Size(min = 6, max = 16, message = "Password invalid (6 to 16 caracters)")
	private String password;
	
	@NotNull(message = "Address Email invalid (72 caracters max)") 
	@Size(max = 72, message = "Address Email invalid (72 caracters max)")
	@Email(message = "Address Email invalid")
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
		return (obj instanceof User)? (this.idUser == ((User) obj).getIdUser()) : super.equals(obj);
	}
	
	public String toString(){
		return "id : "+this.idUser+", username : "+this.username+", email : "+this.email; 
	}
	
	/* Get & Set */
	
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
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
