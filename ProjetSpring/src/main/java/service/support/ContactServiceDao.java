package service.support;

import java.util.List;

import service.ContactService;
import dao.ContactDao;
import domain.User;

public class ContactServiceDao extends ContactService {

	
	/* Attributs */
	
	/** Dao gérant les contacts */
	private ContactDao contactDao; 
	
	/* Méthodes */
	
	@Override
	public List<User> getContactsComplete(String begin, long id) {
		return this.contactDao.getContactsComplete(begin, id);
	}
	
	@Override
	public void addContact(long a, long b) {
		this.contactDao.addContact(a, b);
	}
	
	@Override
	public void removeContact(long a, long b) {
		this.contactDao.removeContact(a, b);
	}
	
	@Override
	public List<User> getContacts(long id) {
		// TODO Auto-generated method stub
		return this.contactDao.getContacts(id);
	}
	
	
	/* Set */
	
	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

}
