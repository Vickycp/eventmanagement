package controller.events;

import java.io.IOException;
import java.io.InputStream;

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
 * Servlet implementation class Eventupdater
 */
@WebServlet("/eventupdater")
@MultipartConfig(maxFileSize = 16177215) 
public class Eventupdater extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Eventupdater() {
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

		InputStream inputStream = null;
		   
        Part filePart = request.getPart("file");
        String Filename="";
        if (filePart != null) {
        	Filename=filePart.getSubmittedFileName();
//        	 System.out.println("hello bro"); 
//            System.out.println(filePart.getSubmittedFileName());
//            System.out.println(filePart.getSize());
//            System.out.println(filePart.getContentType());
//             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
        String id=request.getParameter("id");
	

    Eventdata p = new Eventdata();
   p.setId(Integer.parseInt(id));
   p.setTitle(request.getParameter("title"));
   p.setStart(request.getParameter("start"));
   p.setEnd(request.getParameter("end"));
   p.setDecription(request.getParameter("descripition"));
   p.setFile(Filename);
   p.setStatus(request.getParameter("status"));
   p.setFileip(inputStream);
   int result=Eventhandler.updateEvent(p);

          
  if(result==1) {     
	  Validation.simple("updatemessage", "successfully updated", "eventsmanagement", request, response);
//	response.sendRedirect("eventsmanagement");
  }else {
	  Validation.simple("updatemessage", "Not updated", "eventsmanagement", request, response);
  }
	}

}
