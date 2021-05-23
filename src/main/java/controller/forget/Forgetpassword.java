package controller.forget;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.Databasecon;
import models.Password;

public class Forgetpassword {
       public static boolean changepassword(Password password) {
//    	   boolean newpass= false;
    	   String newpassword = password.getNewpassword();
    	   
    	   boolean result=newpassword.equals(password.getConfirmpassword());
    	   if(result==true) {
    		 
    		   return confirm(password);
    	   }else
    	   {
    		   return false;
    	   }
    	   
    	   
       }
       public static boolean confirm(Password password) {
    	  
    	   boolean status=false;  
     	  try{  
     	  Connection con=Databasecon.getConnection();  
     	                
     	  PreparedStatement ps=con.prepareStatement(  
     	      "update member set password=? where username=?");  
     	 
     	 
     	  ps.setString(1, password.getNewpassword());  
     	 ps.setString(2,password.getUsername());  
     	                
     	  int rs=ps.executeUpdate();  
     	
     	   status=rs==1?true:false;  
     	                
     	  }catch(Exception e){
     		  
     	  }  
     	    
     	  return status;  
     	    
     	  }  
       
    	   
       
       
       
       
}
