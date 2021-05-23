package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

import models.Userinfo;
import models.Validation;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
	       String username = request.getParameter("username");
	       String password = request.getParameter("password");
	       String re=Validation.userName(username);
	       String pas= Validation.passvalid(password);
	       if(re==null) {
                 if(pas==null) {
		       out.println(username+""+password);
		        Userinfo userinfo = new Userinfo(username,password);
		        Registedao registedao =new Registedao();
		       String result= registedao.insert(userinfo);
		       if(result=="Data entered successfully") {
		    	    Cookie ck=new Cookie("name",username);  
		    	    response.addCookie(ck);
		    	   out.print("created suceesull");
		    	   response.sendRedirect("index.jsp");
		       }else {
		    	    out.print("sorry, username or password error!");  
		    	    response.sendRedirect("login.jsp");
		           	       }
                 }else {
                	 Validation.simple("error",pas ,"reg.jsp", request, response);
                 }
		       
	    	   
	       }else {
	    	  Validation.simple("error",re ,"reg.jsp", request, response);
	       }
	       
	        
	}

}
