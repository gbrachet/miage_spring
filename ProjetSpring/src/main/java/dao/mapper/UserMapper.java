package dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import domain.User;


/**
 * Classe effectuant le mapping entre le résultat d'une requête sur la base de données et l'objet java correspondant
 * @author BALLAND Cyriel (cyr.balland@gmail.com) - BRACHET Gautier (g.brachet@gmail.com)
 * @version 1.0 (01/02/2013)
 */
public class UserMapper implements ParameterizedRowMapper<User>  {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException{
		//Instanciation
		User result = new User();
		
		//Copie des données
		result.setIdUser(rs.getInt("idUser"));
		
		result.setUsername(rs.getString("username"));
		result.setPassword(rs.getString("password"));
		result.setEmail(rs.getString("email"));
		
		result.setFirstName(rs.getString("firstName"));
		result.setLastName(rs.getString("lastName"));
		result.setSex(rs.getString("sex"));
		result.setBirthday(rs.getDate("birthday"));
		
		result.setLastConnection(rs.getDate("lastConnection"));
		result.setRegistration(rs.getDate("registration"));
		
		//Retour du résultat
		return result;
	}
	
}
