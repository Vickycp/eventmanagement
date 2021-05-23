package controller.events;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import models.Databasecon;
import models.Eventdata;

public class Eventhandler {
      public  static String createEvent(Eventdata eventdata) {
       String name =eventdata.getUsername();
       String title =eventdata.getTitle();
       String start =eventdata.getStart();
       String end =eventdata.getEnd();
       String status =eventdata.getStatus();
  		Databasecon databasecon =new Databasecon();
  	
  		Connection con =databasecon.getConnection();
  		String result = "Data entered successfully";
  		 String q="INSERT INTO `eventdata`(`username`, `title`, `start`, `end`, `status`, `descripition`, `file`) VALUES (?,?,?,?,?,?,?)";
//		
     PreparedStatement ps;
  		try {
//  			Statement stmt=con.createStatement();
//		        String q="INSERT INTO `eventdata`(`username`, `title`, `start`, `end`, `status`, `descripition`, `file`) VALUES (?,?,?,?,?,?,?)";
//  			String query='INSERT INTO eventdata( `username`, `title`, `start`,`end`, `status`) VALUES ('"+name+"','"+title+"','"+start+"','"+end+"','"+status+"')'';
//  			System.out.println(query);
//  			int count=stmt.executeUpdate(query);
		    ps = con.prepareStatement(q);
			ps.setString(1, name);
			ps.setString(2, title);
			ps.setString(3, start);
			ps.setString(4, end);
			ps.setString(5, status);
			ps.setString(6, "");
			ps.setString(7, "");
			ps.executeUpdate();

  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  			result = "Data not entered";
  		}
  		return result;
  	}
      
      
      public static ArrayList<Eventdata> loadevent(String name) {
         
    	  String sql="SELECT * FROM eventdata where username=?";
    	  ArrayList<Eventdata> userevent = new ArrayList<>();
  		Databasecon databasecon =new Databasecon();
  	
  		Connection con =databasecon.getConnection();
  		String result = "Data entered successfully";
  		PreparedStatement ps;
  		try {
  		ps = con.prepareStatement(sql);
  		ps.setString(1, name);
  	
  		
  		ResultSet r=ps.executeQuery();
  	
  		 while(r.next()) {
  			 
             Eventdata p = new Eventdata();
             p.setId(r.getInt("id"));
             p.setUsername(r.getString("username"));
             p.setTitle(r.getString("title"));
             p.setStart(r.getString("start"));
             p.setEnd(r.getString("end"));
             p.setStatus(r.getString("status"));
             p.setDecription(r.getString("descripition"));
             p.setFile(r.getString("file"));
             
             userevent.add(p);
          }

  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  			result = "Data not entered";
  		}
  		
  		return userevent;
  	
      }
      
      public static int  updateEvent(Eventdata eventdata ) {
    	  int id=eventdata.getId();
    	  String name =eventdata.getUsername();
          String title =eventdata.getTitle();
          String start =eventdata.getStart();
          String end =eventdata.getEnd();
          String status =eventdata.getStatus();
          String description= eventdata.getDecription();
          String file =eventdata.getFile();
          InputStream filedata=eventdata.getFileip();
          
//          System.out.println(id+""+status+""+description);
     		Databasecon databasecon =new Databasecon();
     	
     		Connection con =databasecon.getConnection();
     		int result = 0;
   		  String q1="UPDATE `eventdata` SET `title`=?,`start`=?,`end`=?,`status`=?,`descripition`=?,`file`=?,`filedata`=? WHERE `id`=?";
//     		String q="UPDATE `eventdata`(`title`, `start`, `end`, `status`, `descripition`, `file`,`filedata`) VALUES (?,?,?,?,?,?,?)";
     		PreparedStatement ps;
    	      try {
    	
    	    ps = con.prepareStatement(q1);
			ps.setString(1, title);
			ps.setString(2, start);
			ps.setString(3, end);
			ps.setString(4, status);
			ps.setString(5, description);
			ps.setString(6, file);
			ps.setBlob(7, filedata);
			ps.setInt(8, id);
			int i=ps.executeUpdate();
			if(i==1){result=1;}else{result=0;}
				
			} catch (SQLException e) {
				result=0;
			}
    	  
    	   return result;
    	   
      }
      
      public static ArrayList<Eventdata> loadpendingevent(String name) {
          
    	  String sql="SELECT * FROM eventdata where username=? and status=?";
    	  ArrayList<Eventdata> userevent = new ArrayList<>();
  		Databasecon databasecon =new Databasecon();
  	
  		Connection con =databasecon.getConnection();
  		String result = "Data entered successfully";
  		PreparedStatement ps;
  		try {
  		ps = con.prepareStatement(sql);
  		ps.setString(1, name);
  		ps.setString(2, "pending");
  	
  		
  		ResultSet r=ps.executeQuery();
  
  		 while(r.next()) {
  			 
             Eventdata p = new Eventdata();
             p.setId(r.getInt("id"));
             p.setUsername(r.getString("username"));
             p.setTitle(r.getString("title"));
             p.setStart(r.getString("start"));
             p.setEnd(r.getString("end"));
             p.setStatus(r.getString("status"));
             p.setDecription(r.getString("descripition"));
             p.setFile(r.getString("file"));
             
             userevent.add(p);
          }

  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  			result = "Data not entered";
  		}
  		
  		return userevent;
  	
      }
      
      public static int deleteEventData(int id) {
    	  int r=0;
    	  String sql="DELETE FROM eventdata WHERE id=?";
    	  Databasecon databasecon =new Databasecon();
    	  	
    		Connection con =databasecon.getConnection();
    		String result = "Data deleted Successfully";
    		PreparedStatement ps;
    		try {
    		ps = con.prepareStatement(sql);
    		ps.setInt(1, id);
    	
    		
    		 r=ps.executeUpdate();
    		

    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    			result = "Data not entered";
    			r=0;
    		}
    		return r;
      }
      public static ArrayList<Eventdata> loadeventById(int id) {
          
    	  String sql="SELECT * FROM eventdata where id=?";
    	  ArrayList<Eventdata> userevent = new ArrayList<>();
  		Databasecon databasecon =new Databasecon();
  	
  		Connection con =databasecon.getConnection();
  		String result = "Data entered successfully";
  		PreparedStatement ps;
  		try {
  		ps = con.prepareStatement(sql);
  		ps.setInt(1, id);
  	
  		
  		ResultSet r=ps.executeQuery();
  	
  		 while(r.next()) {
  			 
             Eventdata p = new Eventdata();
             p.setId(r.getInt("id"));
             p.setUsername(r.getString("username"));
             p.setTitle(r.getString("title"));
             p.setStart(r.getString("start"));
             p.setEnd(r.getString("end"));
             p.setStatus(r.getString("status"));
             p.setDecription(r.getString("descripition"));
             p.setFile(r.getString("file"));
             
             userevent.add(p);
          }

  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
//  			e.printStackTrace();
  			result = "Data not entered";
  		}
  		
  		return userevent;
  	
      }
      
   
}
