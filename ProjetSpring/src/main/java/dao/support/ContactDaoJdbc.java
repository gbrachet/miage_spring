package dao.support;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.ContactDao;
import dao.mapper.UserMapper;
import domain.User;

public class ContactDaoJdbc implements ContactDao {
	
	/* Attributs */
	
	private JdbcTemplate jdbcTemplate;
	private UserMapper userMapper;
	
	/* Requêtes */
	
	private static final String COMPLETE_CONTACT = "" +
		"SELECT `User`.* " +
		"FROM `User` " +
		"WHERE `email` LIKE ? " +
		"AND `idUser` NOT IN (SELECT `userA` FROM `Contact` WHERE `userB` = ?) " +
		"AND `idUser` NOT IN (SELECT `userB` FROM `Contact` WHERE `userA` = ?) " +
		"AND `idUser` NOT IN (?) " +
		"LIMIT 10";
	
	private static final String GET_CONTACT = "" +
			"SELECT u.* " +
			"FROM `User` AS u " +
			"LEFT OUTER JOIN `Contact` AS c " +
				"ON (u.`idUser` = c.`userA` OR u.`idUser` = c.`userB`)" +
			"WHERE (c.`userA` = ? OR c.`userB` = ?)" +
			"AND u.`idUser` != ? " +
			"AND `status` = 'valid'" +
			"LIMIT 10";
	
	private static final String ADD_CONTACT = "INSERT INTO `Contact` (`userA`, `userB`, `status`) VALUES (?, ?, 'valid')";
	
	private static final String REMOVE_CONTACT = "UPDATE `Contact` SET `status` = 'blocked' WHERE `userA` IN (?, ?) AND `userB` IN (?, ?) LIMIT 1";
	
	/* Méthodes */
	
	@Override
	public List<User> getContactsComplete(String begin, long id) {
		List<User> user = null;
		
		try{
			user = this.jdbcTemplate.query(COMPLETE_CONTACT, new Object[]{'%'+begin+'%', id, id, id}, this.userMapper);
		} catch(EmptyResultDataAccessException erdae){
			user = null;
		}
		
		return user;
	}
	
	@Override
	public List<User> getContacts(long id) {
		List<User> user = null;
		
		try{
			user = this.jdbcTemplate.query(GET_CONTACT, new Object[]{id, id, id}, this.userMapper);
		} catch(EmptyResultDataAccessException erdae){
			user = null;
		}
		
		return user;
	}
	
	@Override
	public void addContact(long a, long b) {
		//Execution de la requête
		this.jdbcTemplate.update(
			ADD_CONTACT, 
			a, 
			b
		);
	}
	
	@Override
	public void removeContact(long a, long b) {
		//Execution de la requête
		this.jdbcTemplate.update(
			REMOVE_CONTACT, 
			a, 
			b,
			b,
			a
		);
	}
	
	/* Set */
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
