package controller.signin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.Databasecon;
import models.Userinfo;

public class Signindao {
      public static boolean validation(Userinfo userinfo) {
    	    
    	  boolean status=false;  
    	  try{  
    	  Connection con=Databasecon.getConnection();  
    	                
    	  PreparedStatement ps=con.prepareStatement(  
    	      "select * from member where username=? and password=?");  
    	    
    	  ps.setString(1,userinfo.getUsername());  
    	  ps.setString(2, userinfo.getPassword());  
    	                
    	  ResultSet rs=ps.executeQuery();  
    	  status=rs.next();  
    	                
    	  }catch(Exception e){}  
    	    
    	  return status;  
    	    
    	  }  
}
