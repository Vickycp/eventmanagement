<%@page import="models.Eventdata"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="eventupdate.css">
<style type="text/css">
.main {
  margin-left: 160px; /* Same as the width of the sidenav */
  font-size: 28px; /* Increased text to enable scrolling */
  padding: 0px 10px;
}
</style>
</head>
<body>
<%@ include file="nav.jsp" %>
<div class="main">
    <h2 align="center">Edit Events</h2>
<%int count=1; %>
        <%ArrayList<Eventdata> data = (ArrayList<Eventdata>)request.getAttribute("userdatas");
        for(Eventdata s:data){%>
        
		  <div class="container">  
  <form id="contact" action="eventupdater" method="post" enctype="multipart/form-data">
    <h3>update your event</h3>
    <input type="hidden" value=<%=s.getId()%> name="id">
    <fieldset>
    <input type="text" value=<%=s.getTitle()%> name="title" tabindex="1" required autofocus>
      
    </fieldset>
    <fieldset>
    <input type="text" value=<%=s.getStart()%> name="start" tabindex="2">
     
    </fieldset>
    <fieldset>
    <input type="text" value=<%=s.getEnd()%> name="end"  tabindex="3" >
    
    </fieldset>
    <fieldset>
       <input type="file" value=<%=s.getFile()%> name="file" tabindex="4" >
      
    </fieldset>
    <fieldset>
       <textarea id="bio" name="descripition" tabindex="5" ><%=s.getDecription() %></textarea> 
      
    </fieldset>
    <fieldset>
    <select id="eventstatus" name="status" tabindex="6" >
           <optgroup label=""><%=s.getStatus()%>
              <option value="pending">pending</option>
              <option value="completed">completed</option>
              </optgroup>
              </select>
    </fieldset>
    <fieldset>
      <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">update</button>
    </fieldset>
     </form>
</div>		 
		 <% count++;  }%>
    
		 
</div>


</body>
</html>