package dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import domain.Message;

public class MessageMapper implements ParameterizedRowMapper<Message>  {

	public Message mapRow(ResultSet rs, int rowNum) throws SQLException{
		//Instanciation
		Message result = new Message();
		
		//Copie des données
		result.setIdMessage(rs.getInt("idMessage"));
		
		result.setFrom(rs.getInt("from"));
		result.setTo(rs.getInt("to"));
		result.setTitle(rs.getString("title"));
		result.setContent(rs.getString("content"));
		result.setSend(rs.getDate("send"));
		result.setReceive(rs.getDate("receive"));
		result.setRead(rs.getString("read"));
		
		//Retour du résultat
		return result;
	}
}
