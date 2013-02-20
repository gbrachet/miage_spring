package dao.support;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.UserDao;
import dao.mapper.UserMapper;
import domain.User;

public class UserDaoJdbc implements UserDao{
	
	/* Attributs */
	
	private JdbcTemplate jdbcTemplate;
	private UserMapper userMapper;
	
	/* Requêtes */
	
	private static final String GET_USER  = "SELECT uuid, name, mail FROM user where uuid = ?";
	private static final String GET_USER_MAIL  = "SELECT uuid, name, mail FROM user where mail = ?";
	
	/** Requête permettant de connecter un utilisateur */
	private static final String CONNECT = "SELECT * FROM `User` WHERE `email` = ? AND `password` = ? LIMIT 1";
	
	/** Requête permettant de vérifier l'existance d'un email */
	private static final String EMAIL_EXISTS = "SELECT COUNT(`email`) FROM `User` WHERE `email` = ? LIMIT 1";
	
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
		this.jdbcTemplate.update(
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
		this.jdbcTemplate.update(
			UPDATE_USER,
			user.getUsername(), 
			user.getPassword(), 
			user.getEmail(),
			user.getFirstName(),
			user.getLastName(),
			user.getSex(),
			user.getBirthday(),
			user.getIdUser()
		);
	}
	
	@Override
	public void deleteUser(int id) {
		//Execution de la requête
		this.jdbcTemplate.update(DELETE_USER, id);
	}
	
	@Override
	public boolean emailExists(String email) {
		//Requête
		int result = this.jdbcTemplate.queryForInt(EMAIL_EXISTS, email);
		
		//Retour du résultat
		return (result != 0);
	}
	
	@Override
	public User connect(String email, String password) {
		User user = null;
		
		try{
			user = this.jdbcTemplate.queryForObject(CONNECT, new Object[]{email, password}, new UserMapper());
		} catch(EmptyResultDataAccessException erdae){
			user = null;
		}
		
		return user;
	}
	
	
	/* TODO */
	
	@Override
	public List<User> getUsers() {
		return null;
//		return jdbcTemplate.query(GET_USERS, userMapper);
	}

	@Override
	public User getUser(int id) {
		return jdbcTemplate.queryForObject(GET_USER, userMapper, id);
	}
	
	@Override
	public User getUserByMail(String mail) {
		return jdbcTemplate.queryForObject(GET_USER_MAIL, userMapper, mail);
	}
	
	@Override
	public User connection(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	

	

	
	/* Set */
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
