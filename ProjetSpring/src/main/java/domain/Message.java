package domain;

import java.util.Date;

/**
 * Classe modélisant un message
 * @author BALLAND Cyriel (cyr.balland@gmail.com) - BRACHET Gautier (g.brachet@gmail.com)
 * @version 1.0 (01/02/2013)
 */
public class Message {

	/* Attributs */
	
	private int idMessage;
	
	private int from;
	private int to;
	
	private String title;
	private String content;
	
	private Date send;
	private Date receive;
	
	private String read; 		//'y', 'n'
	
	/* Constructeurs */
	
	/**
	 * Constructeur vide
	 */
	public Message(){
		
	}
	
	/* Get & Set */

	public int getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSend() {
		return send;
	}

	public void setSend(Date send) {
		this.send = send;
	}

	public Date getReceive() {
		return receive;
	}

	public void setReceive(Date receive) {
		this.receive = receive;
	}

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}
}
