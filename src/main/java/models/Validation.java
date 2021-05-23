package models;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.validate.ValidatewithDb;

public class Validation {
      public static String userName(String name) {
    	 String res=null;
    	   if(name.length()>4) {
    		       boolean present= ValidatewithDb.uservalidate(name);
    		       if(present==true) {
    		    	      res= "user present create with another name";
    		       }else {
    		    	   res=null;
    		       }
    	   }else {
    		   res ="name should be min 4 char";
    	   }
    	  return res;
      }
       public static String passvalid(String password) {
    	   String pass=null;
    	   if(password.length()>6) {
    		   pass=null;
    	   }else {
    		   pass="password must be > 6";
    	   }
    	   return pass;
       }
       
       public static void simple(String attribute,String message,String path,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   request.setAttribute(attribute, message);
           RequestDispatcher rd = request.getRequestDispatcher(path);
           rd.forward(request, response);
       }
       
       
       public static boolean passwordEqual(Password password) {
//    	 
    	   String newpassword = password.getNewpassword();
    	   
    	   return newpassword.equals(password.getConfirmpassword());
    	   
    	   
    	   
       }
      
}
