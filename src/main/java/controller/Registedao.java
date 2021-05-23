package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Databasecon;
import models.Userinfo;

public class Registedao {
	
	
	
	public String insert(Userinfo userinfo)
	{
		
		
		Databasecon databasecon =new Databasecon();
	
		Connection con =databasecon.getConnection();
		String result = "Data entered successfully";
		String sql = "insert into member(`username`,`password`) values(?,?)";
		
		PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, userinfo.getUsername());
		ps.setString(2, userinfo.getPassword());
		
		ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "Data not entered";
		}
		return result;
	}
}
