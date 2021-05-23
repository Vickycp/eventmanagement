<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
  <div class="login">
    <div class="login-screen">
     <h3 style="color:red;">   <%
    if(null!=request.getAttribute("error"))
    {
        out.println(request.getAttribute("error"));
     
    }
%></h3>
      <div class="app-title">
        <h1>Register</h1>
      </div>
  <form action="register" method="post">
      <div class="login-form">
        <div class="control-group">
        <input type="text" class="login-field" value="" placeholder="username" id="login-name" name="username" required="required">
        <label class="login-field-icon fui-user" for="login-name"></label>
        </div>

        <div class="control-group">
        <input type="password" class="login-field" value="" placeholder="password" id="login-pass" name="password" required="required">
        <label class="login-field-icon fui-lock" for="login-pass"></label>
        </div>
         <button class="btn btn-primary btn-large btn-block" type="submit">register</button>
       <br><a class="login-link" href="login.jsp">already have a account ?</a>
      </div>
      </form>
    </div>
  </div>
</body>
</html>