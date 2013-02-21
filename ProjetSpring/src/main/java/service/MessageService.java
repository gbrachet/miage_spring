package service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import domain.Message;

@WebService
public interface MessageService {

	@WebResult(name = "getMessages")
	public List<Message> getMessages(@WebParam(name="id") long id);
	
	public void addMessage(String message, long from, long to);
}
