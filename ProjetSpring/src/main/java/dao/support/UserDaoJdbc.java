package dao.support;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import dao.UserDao;
import dao.mapper.UserMapper;
import fr.sid.domain.User;

public class UserDaoJdbc implements UserDao{
	
	/* Attributs */
	
	private JdbcTemplate jdbcTemplate;
	private UserMapper userMapper;
	
	/* Requêtes */
	
	private static final String GET_USER  = "SELECT uuid, name, mail FROM user where uuid = ?";
	private static final String GET_USER_MAIL  = "SELECT uuid, name, mail FROM user where mail = ?";
	
	/** Requête permettant d'ajouter un nouvel utilisateur */
	private static final String ADD_USER  = "" +
		"INSERT INTO `User` (`idUser`, `username`, `password`, `email`, `firstName`, `lastName`, `sex`, `birthday`, `registration`) " +
		"VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, NOW())";
	
	/** Requête permettant de mettre à jour un utilisateur */
	private static final String UPDATE_USER = "" +
		"UPDATE `User` SET" +
			"`username` = ?, " +
			"`password` = ?, " +
			"`email` = ?, " +
			"`firstName` = ?, " +
			"`lastName` = ?, " +
			"`sex` = ?, " +
			"`birthday` = ? " +
		"WHERE `idUser` = ?" +
		"LIMIT 1";
	
	/** Requête permettant de supprimer un utilisateur */
	private static final String DELETE_USER = "DELETE FROM `User` WHERE `idUtilisateur` = ? LIMIT 1";
	
	/* Méthodes */
	
	@Override
	public void addUser(User user) {
		//Execution de la requête
		jdbcTemplate.update(
			ADD_USER, 
			user.getUsername(), 
			user.getPassword(), 
			user.getEmail(),
			user.getFirstName(),
			user.getLastName(),
			user.getSex(),
			user.getBirthday()
		);
	}
	
	@Override
	public void updateUser(User user) {
		//Execution de la requête
		jdbcTemplate.update(
			UPDATE_USER,
			user.getUsername(), 
			user.getPassword(), 
			user.getEmail(),
			user.getFirstName(),
			user.getLastName(),
			user.getSex(),
			user.getBirthday(),
			user.getIdUtilisateur()
		);
	}
	
	@Override
	public void deleteUser(int id) {
		//Execution de la requête
		jdbcTemplate.update(DELETE_USER, id);
	}
	
	
	/* TODO */
	
	@Override
	public List<User> getUsers() {
		return null;
//		return jdbcTemplate.query(GET_USERS, userMapper);
	}

	@Override
	public User getUser(int id) {
		return jdbcTemplate.queryForObject(GET_USER, userMapper, uuid);
	}
	
	@Override
	public User getUserByMail(String mail) {
		return jdbcTemplate.queryForObject(GET_USER_MAIL, userMapper, mail);
	}

	






	
	/* Set */
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
