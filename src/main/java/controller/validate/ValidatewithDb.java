package controller.validate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.Databasecon;

public class ValidatewithDb {
        public  static boolean uservalidate(String name) {
        	boolean status =false;
        	try{  
          	  Connection con=Databasecon.getConnection();  
          	                
          	  PreparedStatement ps=con.prepareStatement(  
          	      "select * from member where username=?");  
          	    
          	  ps.setString(1,name);  
          	  
          	                
          	  ResultSet rs=ps.executeQuery();  
          	  while(rs.next()) {  
          		status=true;
          	  }
          	                
          	  }catch(Exception e){
          		  status=false;
          	  }  
          	    
          	  return status;  
          	    
        }
}
