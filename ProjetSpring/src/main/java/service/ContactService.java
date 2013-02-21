package service;

import java.util.List;

import domain.User;

public abstract class ContactService {

	/* Méthodes */
	
	public abstract List<User> getContactsComplete(String begin, long id);
	
	public abstract void addContact(long a, long b);
	
	public abstract void removeContact(long a, long b);
	
	public abstract List<User> getContacts(long id);
}
