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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
.main {
  margin-left: 160px; /* Same as the width of the sidenav */
  font-size: 28px; /* Increased text to enable scrolling */
  padding: 0px 10px;
}
</style>
<script type="text/javascript">

<%
if(null!=request.getAttribute("updatemessage"))
{%>
    alert("updated successfully");
 
<%}
%>

</script>
</head>
<body>
<%@ include file="nav.jsp" %>
<div class="main">
    <h2 align="center">Events</h2>
      	 <%int count=1; %>
        <%ArrayList<Eventdata> data = (ArrayList<Eventdata>)request.getAttribute("userdata");%>
        <%if(data.isEmpty()){%>
           <h2 style="color:white;">no events are created</h2>
        <%} else{%>
<table class="container">
	<thead>
		<tr>
		 <th><h1>sr.no</h1></th>         
          <th><h1>Title</h1></th>
          <th><h1>Start</h1></th>
          <th><h1>End</h1></th>
           <th><h1>des</h1></th>
            <th><h1>file</h1></th>
           <th><h1>Status</h1></th>
           
            
		</tr>
	</thead>
	<tbody>

        
        <% for(Eventdata s:data){ %>
		<tr>
		<form action="updateevents" method="post">
		<input type="hidden" value=<%=s.getId()%> name="id">
			<input type="hidden" value=<%=s.getTitle()%> name="title">
				<input type="hidden" value=<%=s.getStart()%> name="start">
					<input type="hidden" value=<%=s.getEnd()%> name="end">
						<input type="hidden" value=<%=s.getDecription()%> name="descripition">
							<input type="hidden" value=<%=s.getFile()%> name="file">
								<input type="hidden" value=<%=s.getStatus()%> name="status">
			 <td><%= count%></td>
                <td><%=s.getTitle()%></td>
                <td><%=s.getStart()%></td>
                <td><%=s.getEnd()%></td>
                <td><%=s.getDecription()%></td>
                <td><%=s.getFile()%></td>
                <td><%=s.getStatus() %></td>
                <td class="edittd"><button type="submit" vlaue="Edit"><i class="fa fa-edit" ></i></button></td>
         
                
         </form>
         <td class="deltd">
         <form action="deleteevents" method="post">
             	<input type="hidden" value=<%=s.getId()%> name="id">
                <button class="del" type="submit"><i class="fa fa-trash"></i></button>
                </form>
                </td>
		</tr>
		 <% count++;  }%>
	
	</tbody>
</table>
	 <%} %>
</div>
 
   
 
</body>
</html>