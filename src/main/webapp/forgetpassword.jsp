<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
  <div class="login">
    <div class="login-screen">
   <h3 style="color:red;">  <%
    if(null!=request.getAttribute("forgeterror"))
    {
        out.println(request.getAttribute("forgeterror"));
     
    }
%></h3>
      <div class="app-title">
        <h1>create password</h1>
      </div>
<form action="forgetpass" method="post">
      <div class="login-form">
       <div class="control-group">
        <input type="text" name="username" class="login-field" value="" placeholder="username" id="login-name" required="required">
        <label class="login-field-icon fui-user" for="login-name"></label>
        </div>
        <div class="control-group">
        <input type="text" name="newpass" class="login-field" value="" placeholder="new password" id="login-pass" required="required">
        <label class="login-field-icon fui-user" for="login-name"></label>
        </div>

        <div class="control-group">
        <input type="password" name="confirmpass" class="login-field" value="" placeholder="confirm password" id="login-pass" required="required">
        <label class="login-field-icon fui-lock" for="login-pass"></label>
        </div>
     
       
        <button class="btn btn-primary btn-large btn-block" type="submit">save</button>
       <br><a class="login-link" href="login.jsp">login</a>
      </div>
      </form>
    </div>
  </div>
</body>
</html>