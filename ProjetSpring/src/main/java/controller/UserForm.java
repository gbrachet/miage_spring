package controller;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * Class modélisant la récupération d'un utilisateur depuis formulaire
 * @author BALLAND Cyriel (cyr.balland@gmail.com) - BRACHET Gautier (g.brachet@gmail.com)
 * @version 1.0 (19/02/2013)
 */
public class UserForm {
	
	/* Attributs */
	
	@NotNull(message = "Password invalid (6 to 16 caracters)")
	@Size(min = 6, max = 16, message = "Password invalid (6 to 16 caracters)")
	private String password;
	
	@NotNull(message = "Password Confirm invalid (6 to 16 caracters)")
	@Size(min = 6, max = 16, message = "Password Confirm invalid (6 to 16 caracters)")
	private String passwordConfirm;
	
	@NotNull(message = "Address Email invalid (72 caracters max)") 
	@Size(max = 72, message = "Address Email invalid (72 caracters max)")
	@Email(message = "Address Email invalid")
	private String email;

	@Pattern(regexp = "^[f,m]$", message="Sex invalid")
	private String sex;				//'m', 'f'
	
	@Pattern(regexp = "^[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}$", message="Birthday invalid")
	private String birthday;
	
	/* Constructeurs */

	/**
	 * Constructeur vide
	 */
	public UserForm() {
		
	}

	/* Get & Set */
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}
