package service.support;

import java.util.List;

import service.MessageService;
import dao.MessageDao;
import domain.Message;

public class MessageServiceDao implements MessageService {
	
	/* Attributs */
	
	/** Dao gérant les contacts */
	private MessageDao messageDao; 
	
	/* Méthodes */
	
	@Override
	public List<Message> getMessages(long id) {
		return this.messageDao.getMessages(id);
	}
	
	@Override
	public void addMessage(String message, long from, long to) {
		this.messageDao.addMessage(message, from, to);
	}
	
	/* Set */
	
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
}
