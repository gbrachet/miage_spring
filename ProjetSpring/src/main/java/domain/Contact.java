package domain;

/**
 * Classe modélisant un contact entre deux Users
 * @author BALLAND Cyriel (cyr.balland@gmail.com) - BRACHET Gautier (g.brachet@gmail.com)
 * @version 1.0 (01/02/2013)
 */
public class Contact {
	
	/* Attributs */
	
	private int userA;
	private int userB;
	private String status;		//'valid', 'blocked'
	
	/* Constructeurs */
	
	public Contact(){
		
	}
	
	/* Get & Set */
	
	public int getUserA() {
		return userA;
	}

	public void setUserA(int userA) {
		this.userA = userA;
	}

	public int getUserB() {
		return userB;
	}

	public void setUserB(int userB) {
		this.userB = userB;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
