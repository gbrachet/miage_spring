package dao;

import java.util.List;

import domain.User;

public interface ContactDao {

	public List<User> getContactsComplete(String begin, long id);
	
	public List<User> getContacts(long id);
	
	public abstract void removeContact(long a, long b);
	
	public void addContact(long a, long b);
}
