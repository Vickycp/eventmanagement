package controller.events;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import models.Eventdata;
import models.Validation;

/**
 * Servlet implementation class Updateevents
 */
@WebServlet("/updateevents")
@MultipartConfig(maxFileSize = 16177215) 
public class Updateevents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updateevents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	String id=request.getParameter("id");
		
//	System.out.println(request.getParameter("descripition"));
	   ArrayList<Eventdata> user= Eventhandler.loadeventById(Integer.parseInt(id));
	    ArrayList<Eventdata> userdataevents = new ArrayList<>();
	    Eventdata p = new Eventdata();
         p.setId(Integer.parseInt(id));
         p.setTitle(request.getParameter("title"));
         p.setStart(request.getParameter("start"));
         p.setEnd(request.getParameter("end"));
         p.setDecription(request.getParameter("descripition"));
         p.setFile(request.getParameter("file"));
         p.setStatus(request.getParameter("status"));
         
         userdataevents.add(p);
         
        request.setAttribute("userdatas", user);
       RequestDispatcher rd= request.getRequestDispatcher("eventupdate.jsp");
       rd.forward(request,response);
		
	}

}
