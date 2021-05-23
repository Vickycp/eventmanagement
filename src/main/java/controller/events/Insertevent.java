package controller.events;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Eventdata;

/**
 * Servlet implementation class Insertevent
 */
@WebServlet("/insertevent")
public class Insertevent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insertevent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	                     PrintWriter out =response.getWriter();
//	                     out.print("hiii");
//	                     System.out.println("helloo");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);  
        String name=(String)session.getAttribute("name");  
         String title=request.getParameter("title");
         String start=request.getParameter("start");
         String end=request.getParameter("end");
         Eventdata eventdat =new Eventdata(name,title,start,end,"pending");
         String result=Eventhandler.createEvent(eventdat);
         response.sendRedirect("index.jsp");
//         System.out.println(result);
//          System.out.println(name+""+title);
         
	}

}
