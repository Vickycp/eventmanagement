<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String userName = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("name")){ 
		userName = cookie.getValue();
	       
	}
}
}
String da= request.getParameter("title");
String start=request.getParameter("start");
String end=request.getParameter("end");
out.println(da);
System.out.println(userName+""+da+""+start+""+end);

%>
</body>
</html>