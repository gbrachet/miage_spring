package dao.support;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.MessageDao;
import dao.mapper.MessageMapper;
import dao.mapper.UserMapper;
import domain.Message;

public class MessageDaoJdbc implements MessageDao {
	
	/* Attributs */
	
	private JdbcTemplate jdbcTemplate;
	@SuppressWarnings("unused")
	private UserMapper userMapper;
	private MessageMapper messageMapper;
	
	private static final String GET_MESSAGE = "SELECT * FROM `Message` WHERE `to` = ? AND `read` = 'n' ";
	private static final String UPDATE_MESSAGE = "UPDATE `Message` SET `read` = 'y' WHERE `to` = ?";
	private static final String ADD_MESSAGE = "" +
		"INSERT INTO `Message` (`idMessage`, `from`, `to`, `title`, `content`, `send`, `receive`, `read`) " +
		"VALUES (NULL, ?, ?, 'titre', ?, NOW(), NULL, 'n')";
	
	/* Méthodes */
	
	@Override
	public List<Message> getMessages(long id) {
		List<Message> message = null;
		
		try{
			message = this.jdbcTemplate.query(GET_MESSAGE, new Object[]{id}, this.messageMapper);
		} catch(EmptyResultDataAccessException erdae){
			message = null;
		}
		
		if(message != null){
			//Execution de la requête
			this.jdbcTemplate.update(
				UPDATE_MESSAGE,
				id
			);
		}
		
		return message;
	}
	
	@Override
	public void addMessage(String message, long from, long to) {
		//Execution de la requête
		this.jdbcTemplate.update(
			ADD_MESSAGE, 
			from, 
			to, 
			message
		);
	}
	
	/* Set */
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public void setMessageMapper(MessageMapper messageMapper) {
		this.messageMapper = messageMapper;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
