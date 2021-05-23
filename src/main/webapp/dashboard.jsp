
<%@page import="models.Eventdata"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="table.css">
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
     <h2 align="center">Dashboard</h2>
   	 <%int count=1; %>
        <%ArrayList<Eventdata> data = (ArrayList<Eventdata>)request.getAttribute("userdata");%>
        <%if(data.isEmpty()){%>
           <h2 style="color:white;">no events </h2>
        <%} else{%>
        <table class="container">
        <thead>
         <tr>
           <th><h1>srl.no</h1></th>         
          <th><h1>Title</h1></th>
          <th><h1>Start</h1></th>
          <th><h1>End</h1></th>
           <th><h1>Status</h1></th>
         </tr>
         </thead>
         	<tbody>
  
        
       <% for(Eventdata s:data){%>
       
            <tr>
                
                <td><%= count%></td>
                <td><%=s.getTitle()%></td>
                <td><%=s.getStart()%></td>
                <td><%=s.getEnd()%></td>
                <td><%=s.getStatus() %></td>
                
            </tr>
            
            <% count++;  }%>
            	<tbody>
        </table> 
        <%} %>
</div>
 
   
 
</body>
</html>