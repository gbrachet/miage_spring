package service;

import java.util.List;

import domain.Message;

public interface MessageService {

	public List<Message> getMessages(long id);
	
	public void addMessage(String message, long from, long to);
}
