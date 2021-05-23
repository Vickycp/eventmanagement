package controller.forget;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Password;
import models.Validation;

/**
 * Servlet implementation class Forgetpass
 */
@WebServlet("/forgetpass")
public class Forgetpass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forgetpass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   PrintWriter out = response.getWriter();
//	       out.println(request.getParameter("username"));
		   String username =request.getParameter("username");
	       String newpassword = request.getParameter("newpass");
	       String confirmpassword = request.getParameter("confirmpass");
	       Password password =new Password(username,newpassword,confirmpassword);
	       String nam=Validation.userName(username);
	       boolean pas =Validation.passwordEqual(password);
	       if(nam!=null) {
	    	        if(pas==true) {
	    	        	 boolean result=Forgetpassword.changepassword(password);
	    	        	 if(result) {
	    	        		 Validation.simple("errorMessage", "successfully updated", "login.jsp", request, response);
	    	        	 }else {
	    	        		 Validation.simple("forgeterror", "not updated", "forgetpassword.jsp", request, response);
	    	        	 }
	    	        	 
	    	        }else {
	    	        	 Validation.simple("forgeterror", "password not match", "forgetpassword.jsp", request, response);
	    	        }
	       }else {
	    	   Validation.simple("forgeterror", "user not present", "forgetpassword.jsp", request, response);
	       }
	    
	      
	       
	}

}
