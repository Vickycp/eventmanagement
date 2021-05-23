package controller.events;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Eventdata;

/**
 * Servlet implementation class Loadevents
 */
@WebServlet("/loadevents")
public class Loadevents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loadevents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		Eventhandler.loadevent("vicky");
		  HttpSession session=request.getSession(false);  
          String name=(String)session.getAttribute("name"); 
	      
	        ArrayList<Eventdata> userdata = Eventhandler.loadevent(name);
	        
	        request.setAttribute("userdata", userdata);
	       RequestDispatcher rd= request.getRequestDispatcher("dashboard.jsp");
	       rd.forward(request,response);
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
