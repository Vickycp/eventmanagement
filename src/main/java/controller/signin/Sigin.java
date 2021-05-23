package controller.signin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Userinfo;

/**
 * Servlet implementation class Sigin
 */
@WebServlet("/signin")
public class Sigin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sigin() {
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
	       String username = request.getParameter("username");
	       String password = request.getParameter("password");
	     
	        Userinfo userinfo = new Userinfo(username,password);
	      boolean result= Signindao.validation(userinfo);
	      out.print(result);
	      if(result==true) {
	    	  Cookie ck=new Cookie("name",username); 
	    	  ck.setMaxAge(30*60*30);
	    	    response.addCookie(ck);
	    	   out.print("login suceesull");
	    	   
	    	   response.sendRedirect("index.jsp");
	       }else {
	    	   request.setAttribute("errorMessage", "Invalid user or password");
               RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
               rd.forward(request, response);
            
				
	           	       }
	       
	}

}
